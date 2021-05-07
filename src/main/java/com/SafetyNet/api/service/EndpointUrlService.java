package com.SafetyNet.api.service;

import com.SafetyNet.api.dao.FirestationDAO;
import com.SafetyNet.api.dao.MedicalRecordDAO;
import com.SafetyNet.api.dao.PersonDAO;
import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.service.object.ChildrenByAdressObject;
import com.SafetyNet.api.service.object.EndpointsUrlsObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EndpointUrlService {

    @Autowired
    private PersonDAO        personDAO;
    @Autowired
    private FirestationDAO   firestationDAO;
    @Autowired
    private MedicalRecordDAO medicalRecordDAO;


    public List<Person> getMailsByCity(String city) {

        return  personDAO.findEmailByCity(city);
    }


    public EndpointsUrlsObject getPersonsByFirestation(int stationNumber) throws ParseException {

        Ages ages = new Ages();
        List<Person> listPersonLocal = new ArrayList<Person>();
        for (Firestation firestation : firestationDAO.findAddressByStation(stationNumber)) {
            List<Person> listPersonTmp = personDAO.findByAddress(firestation.getAddress());
            listPersonLocal.addAll(listPersonTmp);

            for (Person person : listPersonTmp) {
                MedicalRecord medicalRecord = medicalRecordDAO.findByFirstName(person.getFirstName());
                ages.calculateDate(medicalRecord.getBirthdate());
            }
        }
        return new EndpointsUrlsObject(listPersonLocal,
                ages.getAdults(),
                ages.getChildren());
    }

    public ChildrenByAdressObject showChildrenByAddress(String address) throws ParseException {

        List<Person> listPersonLocal = new ArrayList<Person>();
        List<Person> listPerson2 = personDAO.findByAddress(address);
        listPersonLocal.addAll(listPerson2);

        Ages ages = new Ages();
        List<MedicalRecord> listMedicalRecords = new ArrayList<MedicalRecord>();
        for (Person person : listPerson2) {
            MedicalRecord medicalRecord = medicalRecordDAO.findByFirstName(person.getFirstName());
            listMedicalRecords.add(medicalRecord);
            ages.calculateDate(medicalRecord.getBirthdate());
        }

        return new ChildrenByAdressObject(listPersonLocal, listMedicalRecords, ages.getListAge(),
                ages.getChildren());
    }
}
