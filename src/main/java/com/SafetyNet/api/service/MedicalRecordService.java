package com.SafetyNet.api.service;

import com.SafetyNet.api.dao.MedicalRecordDAO;
import com.SafetyNet.api.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordDAO medicalRecordDAO;

    @Autowired
    public MedicalRecordService(MedicalRecordDAO medicalRecordDAO) {

        this.medicalRecordDAO = medicalRecordDAO;

    }

    public List<MedicalRecord> findAll() {

        return medicalRecordDAO.findAll();
    }

    public MedicalRecord findById(String address) {

        return medicalRecordDAO.findById(address);
    }

    public List<MedicalRecord> save(MedicalRecord medicalRecord) {

        return medicalRecordDAO.save(medicalRecord);
    }

    public MedicalRecord update(String address, MedicalRecord medicalRecord) throws ParseException {

        return medicalRecordDAO.update(address, medicalRecord);
    }

    public void deleteById(String address) {

        medicalRecordDAO.deleteById(address);
    }

}
