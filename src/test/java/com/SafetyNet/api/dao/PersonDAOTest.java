package com.SafetyNet.api.dao;

import com.SafetyNet.api.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonDAOTest {

    private List<Person>  listPersons;
    private PersonDAOImpl personDaoImpl;

    @BeforeEach
    public void setUp() throws Exception {

        personDaoImpl = new PersonDAOImpl(listPersons);
    }

    @Test
    public void findAll() {

        List<Person> listPerson;
        listPerson = new ArrayList<Person>();
        listPerson = personDaoImpl.findAll();
        assertThat(listPerson.toString(), containsString("John"));
    }

    @Test
    public void findById() {
        // ARRANGE
        Person person               = new Person(); // method return value
        String firstNameAndlastName = "JohnBoyd"; // parameter
        // ACT
        person = personDaoImpl.findById(firstNameAndlastName);
        // ASSERT
        assertThat("JohnBoyd", containsString(person.getfirstNameAndlastName()));

    }

    @Test
    public void findByLastName() {
        // ARRANGE
        String lastName = "Boyd"; // parameter

        assertThat(personDaoImpl.findByLastName(lastName).toString(), containsString("Boyd"));

    }

    @Test
    public void findByAdress() {
        // ARRANGE
        String address = "1509 Culver St"; // parameter

        assertThat(personDaoImpl.findByAddress(address).toString(), containsString("1509 Culver St"));

    }

    @Test
    public void findByCity() {
        // ARRANGE
        String city = "Culver"; // parameter

        assertThat(personDaoImpl.findEmailByCity(city).toString(), containsString("Culver"));

    }

    @Test
    public void save() {
        // ARRANGE
        Person person = new Person(); // parameter
        person.setFirstName("AAAA");
        // ACT
        personDaoImpl.save(person);
        // ASSERT
        listPersons = personDaoImpl.findAll();
        assertThat(listPersons.toString(), containsString("AAAA"));

    }

    @Test
    public void update() {
        // ARRANGE
        String firstNameAndlastName = "JohnBoyd"; // parameter
        Person person               = new Person(); // parameter
        person.setFirstName("AAAA");
        person.setCity("BBBB");
        // ACT
        personDaoImpl.update(firstNameAndlastName, person);
        // ASSERT
        listPersons = personDaoImpl.findAll();
        assertThat(listPersons.toString(), containsString("BBBB"));
        Assertions.assertFalse(listPersons.toString().contains("AAAA"));
        assertThat(listPersons.toString(), containsString("email=null"));

    }

    @Test
    public void deleteById() {
        // ARRANGE
        String firstNameAndlastName = "JohnBoyd"; // parameter
        // ACT
        personDaoImpl.deleteById(firstNameAndlastName);
        // ASSERT
        listPersons = personDaoImpl.findAll();
        Assertions.assertFalse(listPersons.toString().contains("John"));
    }
}
