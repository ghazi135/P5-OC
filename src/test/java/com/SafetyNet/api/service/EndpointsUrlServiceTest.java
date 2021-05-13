package com.SafetyNet.api.service;
import com.SafetyNet.api.dao.FirestationDAO;
import com.SafetyNet.api.dao.MedicalRecordDAO;
import com.SafetyNet.api.dao.PersonDAO;
import com.SafetyNet.api.dto.*;
import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class EndpointsUrlServiceTest {


    List<Person> listPerson;

    private EndpointUrlService endpointUrlService;
    @Mock
    private PersonDAO        personDAO;


    @Mock
    private FirestationDAO   firestationDAO;

    @Mock
    private MedicalRecordDAO medicalRecordDAO;
    @Mock
    private Ages             ages = new Ages();

    @BeforeEach
    void setup() {

        endpointUrlService = new EndpointUrlService(personDAO,firestationDAO,medicalRecordDAO);
    }

    @Test
   public void getMailsByCity(){
        listPerson = new ArrayList<Person>();
        Person person = new Person();
        person.setAddress("15 rue colonel dumont");
        person.setFirstName("ghazi");
        person.setLastName("bouzazi");
        person.setEmail("gbouzazi@gmail.com");
        person.setCity("grenoble");
        person.setZip(38000);
        person.setPhone("0782427444");
        listPerson.add(person);
        when(personDAO.findEmailByCity("grenoble")).thenReturn(listPerson);


        assertThat(endpointUrlService.getMailsByCity("grenoble").getEmail().toString(), containsString("gbouzazi@gmail.com") );;

   }

    @Test
    public void getPersonInfoByPerson() throws ParseException {
        listPerson = new ArrayList<Person>();
        Person person = new Person();
        person.setAddress("15 rue colonel dumont");
        person.setFirstName("ghazi");
        person.setLastName("bouzazi");
        person.setEmail("gbouzazi@gmail.com");
        person.setCity("grenoble");
        person.setZip(38000);
        person.setPhone("0782427444");
        listPerson.add(person);

        MedicalRecord   medicalRecord = new MedicalRecord();
        List<String> medication    = new ArrayList<String>();
        List<String> allergie = new ArrayList<String>();
        allergie.add("AAAA");
        allergie.add("BBBB");
        medication.add("AAAA");
        medication.add("BBBB");
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/1994");
        when(personDAO.findByLastName("bouzazi")).thenReturn(listPerson);
        when(medicalRecordDAO.findByFirstName(person.getFirstName())).thenReturn(medicalRecord);

        for(PersonInfoDTO personInfoDTO: endpointUrlService.getPersonInfoByPerson("ghazi", "bouzazi")){
            assertThat(personInfoDTO.getEmail(), containsString("gbouzazi@gmail.com") );
            assertThat(personInfoDTO.getAge().toString(), containsString("26") );
            assertThat(personInfoDTO.getLastName(), containsString("bouzazi") );
            assertThat(personInfoDTO.getAllergies().toString(), containsString(allergie.toString()) );
            assertThat(personInfoDTO.getMedications().toString(), containsString(medication.toString()) );
        }

    }

    @Test
    public void getChildrenByAddress() throws ParseException {
        listPerson = new ArrayList<Person>();
        Person person = new Person();
        person.setAddress("15 rue colonel dumont");
        person.setFirstName("ghazi");
        person.setLastName("bouzazi");
        person.setEmail("gbouzazi@gmail.com");
        person.setCity("grenoble");
        person.setZip(38000);
        person.setPhone("0782427444");
        listPerson.add(person);

        MedicalRecord   medicalRecord = new MedicalRecord();
        List<String> medication    = new ArrayList<String>();
        List<String> allergie = new ArrayList<String>();
        allergie.add("AAAA");
        allergie.add("BBBB");
        medication.add("AAAA");
        medication.add("BBBB");
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/2011");
        when(personDAO.findByAddress(any(String.class))).thenReturn(listPerson);
        when(medicalRecordDAO.findByFirstName(any(String.class))).thenReturn(medicalRecord);
        for (ChildrenByAdressDTO childrenByAdressDTO : endpointUrlService.getChildrenByAddress("15 rue colonel dumont")){
            assertThat(childrenByAdressDTO.getFirstName(), containsString("ghazi"));
            assertThat(childrenByAdressDTO.getLastName(), containsString("bouzazi"));
        }

    }

    @Test
    public void getChildrenByAddressWithNoChildren() throws ParseException {
        listPerson = new ArrayList<Person>();
        Person person = new Person();
        person.setAddress("15 rue colonel dumont");
        person.setFirstName("ghazi");
        person.setLastName("bouzazi");
        person.setEmail("gbouzazi@gmail.com");
        person.setCity("grenoble");
        person.setZip(38000);
        person.setPhone("0782427444");
        listPerson.add(person);

        MedicalRecord   medicalRecord = new MedicalRecord();
        List<String> medication    = new ArrayList<String>();
        List<String> allergie = new ArrayList<String>();
        allergie.add("AAAA");
        allergie.add("BBBB");
        medication.add("AAAA");
        medication.add("BBBB");
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/1994");
        when(personDAO.findByAddress(any(String.class))).thenReturn(listPerson);
        when(medicalRecordDAO.findByFirstName(any(String.class))).thenReturn(medicalRecord);
           assertNull(endpointUrlService.getChildrenByAddress("15 rue colonel dumont"));


    }
    @Test
    public void getPhoneNumbersByFirestation(){
        listPerson = new ArrayList<Person>();
        List<Firestation> firestationList = new ArrayList<Firestation>();
        Person person = new Person();
        Firestation firestation = new Firestation();
        firestation.setStation(2);
        firestation.setAddress("15 rue colonel dumont");
        firestationList.add(firestation);
        person.setAddress("15 rue colonel dumont");
        person.setFirstName("ghazi");
        person.setLastName("bouzazi");
        person.setEmail("gbouzazi@gmail.com");
        person.setCity("grenoble");
        person.setZip(38000);
        person.setPhone("0782427444");
        listPerson.add(person);
        when(firestationDAO.findAddressByStation(2)).thenReturn(firestationList);
        when(personDAO.findByAddress("15 rue colonel dumont")).thenReturn(listPerson);

        List<PhoneAlertByStationNumberDTO> phoneAlertByStationNumberDTOList = Collections.singletonList(endpointUrlService
                .getPhoneNumbersByFirestation(2));
        for (PhoneAlertByStationNumberDTO phoneAlertByStationNumberDTO : phoneAlertByStationNumberDTOList )
            assertThat(phoneAlertByStationNumberDTO.getPhonePersonList().toString(), containsString("0782427444"));
    }

    @Test
    public void getPersonsByAddress() throws ParseException {
        listPerson = new ArrayList<Person>();
        Person person = new Person();
        Firestation firestation = new Firestation();
        firestation.setStation(2);
        firestation.setAddress("15 rue colonel dumont");
        person.setAddress("15 rue colonel dumont");
        person.setFirstName("ghazi");
        person.setLastName("bouzazi");
        person.setEmail("gbouzazi@gmail.com");
        person.setCity("grenoble");
        person.setZip(38000);
        person.setPhone("0782427444");
        listPerson.add(person);

        MedicalRecord   medicalRecord = new MedicalRecord();
        List<String> medication    = new ArrayList<String>();
        List<String> allergie = new ArrayList<String>();
        allergie.add("AAAA");
        allergie.add("BBBB");
        medication.add("AAAA");
        medication.add("BBBB");
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/1994");
        when(personDAO.findByAddress("15 rue colonel dumont")).thenReturn(listPerson);
        when(medicalRecordDAO.findByFirstName("ghazi")).thenReturn(medicalRecord);
        when(firestationDAO.findById("15 rue colonel dumont")).thenReturn(firestation);

        List<ListPersonByAdressDTO> listPersonByAdressDTOList =  Collections.singletonList(endpointUrlService.getPersonsByAddress("15 rue colonel dumont")) ;
        for(ListPersonByAdressDTO listPersonByAdressDTO:listPersonByAdressDTOList) {
            assertThat(listPersonByAdressDTO.getFirestation().toString(), containsString("15 rue colonel dumont"));
        }

    }

    @Test
    public void getPersonsAddressByFirestations() throws ParseException {
        listPerson = new ArrayList<Person>();
        List<Firestation> firestationList = new ArrayList<Firestation>();
        Person person = new Person();
        Firestation firestation = new Firestation();
        firestation.setStation(2);
        firestation.setAddress("15 rue colonel dumont");
        firestationList.add(firestation);
        person.setAddress("15 rue colonel dumont");
        person.setFirstName("ghazi");
        person.setLastName("bouzazi");
        person.setEmail("gbouzazi@gmail.com");
        person.setCity("grenoble");
        person.setZip(38000);
        person.setPhone("0782427444");
        listPerson.add(person);

        MedicalRecord   medicalRecord = new MedicalRecord();
        List<String> medication    = new ArrayList<String>();
        List<String> allergie = new ArrayList<String>();
        allergie.add("AAAA");
        allergie.add("BBBB");
        medication.add("AAAA");
        medication.add("BBBB");
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/1994");
        List<Integer> stations = new ArrayList<Integer>();
        stations.add(1);
        stations.add(2);
        when(firestationDAO.findAddressByStation(any(int.class))).thenReturn(firestationList);
        when(medicalRecordDAO.findByFirstName(person.getFirstName())).thenReturn(medicalRecord);
        when(personDAO.findByAddress("15 rue colonel dumont")).thenReturn(listPerson);
        List<PersonsAddressByFirestationDTO> personsAddressByFirestationDTOList =  endpointUrlService.getPersonsAddressByFirestations(stations);
        for(PersonsAddressByFirestationDTO personsAddressByFirestationDTO:personsAddressByFirestationDTOList) {
            assertThat(personsAddressByFirestationDTO.getLastName(), containsString("bouzazi"));
        }


    }

    @Test
    public void getPersonsByFirestation() throws ParseException {
        listPerson = new ArrayList<Person>();
        List<Firestation> firestationList = new ArrayList<Firestation>();
        Person person = new Person();
        Firestation firestation = new Firestation();
        firestation.setStation(2);
        firestation.setAddress("15 rue colonel dumont");
        firestationList.add(firestation);
        person.setAddress("15 rue colonel dumont");
        person.setFirstName("ghazi");
        person.setLastName("bouzazi");
        person.setEmail("gbouzazi@gmail.com");
        person.setCity("grenoble");
        person.setZip(38000);
        person.setPhone("0782427444");
        listPerson.add(person);

        MedicalRecord   medicalRecord = new MedicalRecord();
        List<String> medication    = new ArrayList<String>();
        List<String> allergie = new ArrayList<String>();
        allergie.add("AAAA");
        allergie.add("BBBB");
        medication.add("AAAA");
        medication.add("BBBB");
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/1994");

        when(firestationDAO.findAddressByStation(any(int.class))).thenReturn(firestationList);
        when(medicalRecordDAO.findByFirstName(person.getFirstName())).thenReturn(medicalRecord);
        when(personDAO.findByAddress("15 rue colonel dumont")).thenReturn(listPerson);
            assertNotNull(endpointUrlService.getPersonsByFirestation(2));

            for (Person personn : endpointUrlService.getPersonsByFirestation(2).getListPersons() ){
                assertThat(personn.getFirstName(), containsString("ghazi"));

            }
    }

    }

