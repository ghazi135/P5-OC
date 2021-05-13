package com.SafetyNet.api.service;

import com.SafetyNet.api.dao.PersonDAO;
import com.SafetyNet.api.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
class PersonServiceTest {


    List<Person> listPerson;
    @Mock
    PersonDAO personDAO;

    PersonService personService;

    @BeforeEach
    void setup() {

        personService = new PersonService(personDAO);
    }

    @Test
    public void findAll() {

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
        when(personDAO.findAll()).thenReturn(listPerson);


        assertThat(personService.findAll().toString(), containsString("ghazi"));
    }

    @Test
    public void findAllById() {

        Person person = new Person();
        person.setAddress("15 rue colonel dumont");
        person.setFirstName("ghazi");
        person.setLastName("bouzazi");
        person.setEmail("gbouzazi@gmail.com");
        person.setCity("grenoble");
        person.setZip(38000);
        person.setPhone("0782427444");
        when(personDAO.findById("ghazibouzazi")).thenReturn(person);


        assertThat(personService.findById("ghazibouzazi").toString(), containsString("ghazi"));
    }

    @Test
    public void savePerson() {

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
        when(personDAO.findAll()).thenReturn(listPerson);
        personDAO.save(person);
        assertThat(personService.save(person).toString(), containsString("ghazi"));
    }

    @Test
    public void updatePerson() {

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
        when(personDAO.update("ghazibouzazi", person)).thenReturn(person);


        assertThat(personService.update("ghazibouzazi", person).toString(), containsString("ghazi"));
    }

    @Test
    public void deletePerson() {

        listPerson = new ArrayList<Person>();
        Person person = new Person();
        person.setAddress("15 rue colonel dumont");
        person.setFirstName("ghazi");
        person.setLastName("bouzazi");
        person.setEmail("gbouzazi@gmail.com");
        person.setCity("grenoble");
        person.setZip(38000);
        person.setPhone("0782427444");
        personDAO.save(person);
        assertThat(personService.deleteById("ghazibouzazi").toString(), containsString(""));
    }
}



