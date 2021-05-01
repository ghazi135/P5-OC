package com.SafetyNet.api;

import com.SafetyNet.api.dao.PersonDAO;
import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
class PersonServiceTest {


    List<Person> listPerson;
    @Autowired
    @MockBean
     PersonDAO personDAO;

    PersonService personService;

    @BeforeEach
    void setup() {
        personService = new PersonService(personDAO);
    }

    @Test
    public void findAll() {
//
//        listPerson = new ArrayList<Person>();
//        Person person = new Person();
//        person.setAddress("15 rue colonel dumont");
//        person.setFirstName("ghazi");
//        person.setLastName("bouzazi");
//        person.setEmail("gbouzazi@gmail.com");
//        person.setCity("grenoble");
//        person.setZip(38000);
//        person.setPhone("0782427444");
//        listPerson.add(person);
//        when(personDAO.findAll()).thenReturn(listPerson);
//
//
//        assertThat( personService.findAll().toString(), containsString("ghazi"));
    }

}


