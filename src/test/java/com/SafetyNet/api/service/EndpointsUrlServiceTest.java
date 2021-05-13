package com.SafetyNet.api.service;
import com.SafetyNet.api.dao.FirestationDAO;
import com.SafetyNet.api.dao.MedicalRecordDAO;
import com.SafetyNet.api.dao.PersonDAO;
import com.SafetyNet.api.dto.PersonInfoDTO;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
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
            assertThat(personInfoDTO.getEmail(), containsString("gbouzazi@gmail.com") );;
        }

    }

}
