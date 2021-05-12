package com.SafetyNet.api.service;

import com.SafetyNet.api.dao.FirestationDAO;
import com.SafetyNet.api.dao.MedicalRecordDAO;
import com.SafetyNet.api.dao.PersonDAO;
import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private PersonInfoDTO    personDTO;
    private Ages             ages = new Ages();
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
                ages.calculateDate(new SimpleDateFormat("MM/dd/yyyy").parse(medicalRecord.getBirthdate()));
            }
        }
        return new PersonByFirestationDTO(listPersonLocal,
                ages.getAdults(),
                ages.getChildren());
    }

    public List<ChildrenByAdressDTO> showChildrenByAddress(String address) throws ParseException {

        List<ChildrenByAdressDTO> childrenByAdressDTOList = new ArrayList<ChildrenByAdressDTO>();
        List<Person> listPerson2 = personDAO.findByAddress(address);
        ages = new Ages();
        List<MedicalRecord> listMedicalRecords = new ArrayList<MedicalRecord>();
        for (Person person : listPerson2) {
            MedicalRecord medicalRecord = medicalRecordDAO.findByFirstName(person.getFirstName());
            listMedicalRecords.add(medicalRecord);
            ages.calculateDate(new SimpleDateFormat("MM/dd/yyyy").parse(medicalRecord.getBirthdate()));
            childrenByAdressDTOList.add(new ChildrenByAdressDTO(person.getFirstName(),person.getLastName(),ages.getAge()));
        }
        if(ages.getChildren() == 0){
            return null;
        }
        else
        {
            return childrenByAdressDTOList;
        }


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
            ages.calculateDate(new SimpleDateFormat("MM/dd/yyyy").parse(medicalRecord.getBirthdate()));
        }

        return new ListPersonByAdressDTO(listPersonLocal, listMedicalRecordsLocal, firestationLocal,
                ages.getListAge());
    }

    public List<PersonsAddressByFirestationDTO> showPersonsAddressByFirestations(List<Integer> stations) throws ParseException {

        List<PersonsAddressByFirestationDTO> personsAddressByFirestationDTOList = new ArrayList<PersonsAddressByFirestationDTO>();
        Ages ages = new Ages();
        List<Person> listPersonLocal = new ArrayList<Person>();

        for (Integer station : stations){


            for (Firestation firestation : firestationDAO.findAddressByStation(station)) {
                List<Person> listPerson2 = personDAO.findByAddress(firestation.getAddress());
                listPersonLocal.addAll(listPerson2);
            }

            List<MedicalRecord> listMedicalRecordsLocal = new ArrayList<MedicalRecord>();
            for (Person person : listPersonLocal) {
                MedicalRecord medicalRecord = medicalRecordDAO.findByFirstName(person.getFirstName());
                listMedicalRecordsLocal.add(medicalRecord);
                ages.calculateDate(new SimpleDateFormat("MM/dd/yyyy").parse(medicalRecord.getBirthdate()));
                personsAddressByFirestationDTOList.add(new PersonsAddressByFirestationDTO(person.getLastName(),person.getPhone(),ages.getAge(),medicalRecord.getMedications(),medicalRecord.getAllergies()));
            }
        }


        return personsAddressByFirestationDTOList;
    }

    public List<PersonInfoDTO> showPersonInfoByPerson(String firstName, String lastName) throws ParseException {

        List<Person>        listPerson2     = personDAO.findByLastName(lastName);
        List<Person>        listPersonLocal = new ArrayList<Person>(listPerson2);
        List<PersonInfoDTO> personDTOList   = new ArrayList<PersonInfoDTO>();
        ages = new Ages();
        for (Person person : listPersonLocal) {

            MedicalRecord medicalRecord = medicalRecordDAO.findByFirstName(person.getFirstName());
            ages.calculateDate(new SimpleDateFormat("MM/dd/yyyy").parse(medicalRecord.getBirthdate()));
             personDTOList.add(new PersonInfoDTO(person.getLastName(), person.getAddress(), person.getEmail(), ages.getAge(),medicalRecord.getAllergies(),medicalRecord.getMedications()));
        }

        return personDTOList;
    }


}
