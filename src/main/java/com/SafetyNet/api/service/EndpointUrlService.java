package com.SafetyNet.api.service;

import com.SafetyNet.api.dao.FirestationDAO;
import com.SafetyNet.api.dao.MedicalRecordDAO;
import com.SafetyNet.api.dao.PersonDAO;
import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.DTO.*;
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

    private Ages ages = new Ages();
    public List<Person> getMailsByCity(String city) {

        return  personDAO.findEmailByCity(city);
    }


    public PersonByFirestationDTO getPersonsByFirestation(int stationNumber) throws ParseException {

         ages = new Ages();
        List<Person> listPersonLocal = new ArrayList<Person>();
        for (Firestation firestation : firestationDAO.findAddressByStation(stationNumber)) {
            List<Person> listPersonTmp = personDAO.findByAddress(firestation.getAddress());
            listPersonLocal.addAll(listPersonTmp);

            for (Person person : listPersonTmp) {
                MedicalRecord medicalRecord = medicalRecordDAO.findByFirstName(person.getFirstName());
                ages.calculateDate(medicalRecord.getBirthdate());
            }
        }
        return new PersonByFirestationDTO(listPersonLocal,
                ages.getAdults(),
                ages.getChildren());
    }

    public ChildrenByAdressDTO showChildrenByAddress(String address) throws ParseException {

        List<Person> listPersonLocal = new ArrayList<Person>();
        List<Person> listPerson2 = personDAO.findByAddress(address);
        listPersonLocal.addAll(listPerson2);

         ages = new Ages();
        List<MedicalRecord> listMedicalRecords = new ArrayList<MedicalRecord>();
        for (Person person : listPerson2) {
            MedicalRecord medicalRecord = medicalRecordDAO.findByFirstName(person.getFirstName());
            listMedicalRecords.add(medicalRecord);
            ages.calculateDate(medicalRecord.getBirthdate());
        }

        return new ChildrenByAdressDTO(listPersonLocal, listMedicalRecords, ages.getListAge(),
                ages.getChildren());
    }

    public PhoneAlertByStationNumberDTO getPhoneNumbersByFirestation(int firestation) {

        List<Person> listPersonLocal = new ArrayList<Person>();
        List<String> listPhones = new ArrayList<String>();
        for (Firestation firestation1 : firestationDAO.findAddressByStation(firestation)) {
            listPersonLocal.addAll(personDAO.findByAddress(firestation1.getAddress()));
        }
        for (Person person : listPersonLocal) {
        listPhones.add(person.getPhone());
        }



        return  new PhoneAlertByStationNumberDTO(listPhones);
    }


    public ListPersonByAdressDTO getPersonsByAddress(String address) throws ParseException {
        Firestation firestationLocal = firestationDAO.findById(address);

        List<Person> listPersonLocal = new ArrayList<Person>();
        List<Person> listPerson2 = personDAO.findByAddress(firestationLocal.getAddress());
        listPersonLocal.addAll(listPerson2);

         ages = new Ages();
        List<MedicalRecord> listMedicalRecordsLocal = new ArrayList<MedicalRecord>();
        for (Person person : listPerson2) {
            MedicalRecord medicalRecord = medicalRecordDAO.findByFirstName(person.getFirstName());
            listMedicalRecordsLocal.add(medicalRecord);
            ages.calculateDate(medicalRecord.getBirthdate());
        }

        return new ListPersonByAdressDTO(listPersonLocal, listMedicalRecordsLocal, firestationLocal,
                ages.getListAge());
    }

    public PersonsAddressByFirestationDTO showPersonsAddressByFirestation(int stations) throws ParseException {


        Ages ages = new Ages();
        List<Person> listPersonLocal = new ArrayList<Person>();
        for (Firestation firestation : firestationDAO.findAddressByStation(stations)) {
            List<Person> listPerson2 = personDAO.findByAddress(firestation.getAddress());
            listPersonLocal.addAll(listPerson2);
        }

        List<MedicalRecord> listMedicalRecordsLocal = new ArrayList<MedicalRecord>();
        for (Person person : listPersonLocal) {
            MedicalRecord medicalRecord = medicalRecordDAO.findByFirstName(person.getFirstName());
            listMedicalRecordsLocal.add(medicalRecord);
            ages.calculateDate(medicalRecord.getBirthdate());
        }

        return new PersonsAddressByFirestationDTO(listPersonLocal, listMedicalRecordsLocal, ages.getListAge());
    }

    public PersonInfoDTO showPersonInfoByPerson(String firstName, String lastName) throws ParseException {

        List<Person> listPerson2 = personDAO.findByLastName(lastName);
        List<Person> listPersonLocal = new ArrayList<Person>(listPerson2);

        ages = new Ages();
        List<MedicalRecord> listMedicalRecordsLocal = new ArrayList<MedicalRecord>();
        for (Person person : listPersonLocal) {
            MedicalRecord medicalRecord = medicalRecordDAO.findByFirstName(person.getFirstName());
            listMedicalRecordsLocal.add(medicalRecord);
            ages.calculateDate(medicalRecord.getBirthdate());
        }

        return new PersonInfoDTO(listPersonLocal, listMedicalRecordsLocal, ages.getListAge());
    }


}
