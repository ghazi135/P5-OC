package com.SafetyNet.api.dao;

import com.SafetyNet.api.json.DataReaderService;
import com.SafetyNet.api.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRecordDAOImpl implements MedicalRecordDAO {

    private final List<MedicalRecord> medicalRecords;

    @Autowired
    public MedicalRecordDAOImpl(List<MedicalRecord> medicalRecord) throws Exception {
        super();
        medicalRecord = new DataReaderService().getData().getMedicalRecords();
        this.medicalRecords = medicalRecord;
    }

    @Override
    public List<MedicalRecord> findAll() {
        return medicalRecords;
    }

    @Override
    public MedicalRecord findById(String firstNameAndlastName) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getFirstNameAndlastName().equals(firstNameAndlastName)) {
                return medicalRecord;
            }
        }
        return null;
    }

    @Override
    public MedicalRecord findByFirstName(String firstName) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getFirstName().equals(firstName)) {
                return medicalRecord;
            }
        }
        return null;
    }

    @Override
    public List<MedicalRecord> findByLastName(String lastName) {
        List<MedicalRecord> listMedicalRecords = new ArrayList<MedicalRecord>();
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getLastName().equals(lastName)) {
                listMedicalRecords.add(medicalRecord);
            }
        }
        return listMedicalRecords;
    }

    @Override
    public List<MedicalRecord> save(MedicalRecord medicalRecord) {
        List<MedicalRecord> saveMedicalRecord = medicalRecords;
        saveMedicalRecord.add(medicalRecord);
        return saveMedicalRecord;
    }

    @Override
    public MedicalRecord update(String firstNameAndlastName, MedicalRecord medicalRecord) throws ParseException {
        for (MedicalRecord updateMedicalRecord : medicalRecords) {
            if (updateMedicalRecord.getFirstNameAndlastName().equals(firstNameAndlastName)) {
                updateMedicalRecord.setBirthdate(medicalRecord.getBirthdate().toString());
                updateMedicalRecord.setMedications(medicalRecord.getMedications());
                updateMedicalRecord.setAllergies(medicalRecord.getAllergies());
                return updateMedicalRecord;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String firstNameAndlastName) {

        medicalRecords.removeIf(medicalRecord -> medicalRecord.getFirstNameAndlastName().equals(firstNameAndlastName));

    }
}
