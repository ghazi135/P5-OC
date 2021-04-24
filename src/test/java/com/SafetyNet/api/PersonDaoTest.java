package com.SafetyNet.api;

import com.SafetyNet.api.Model.Person;
import com.SafetyNet.api.dao.PersonDaoImpl;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

public class PersonDaoTest {
    private List<Person>  listPersons;
    private PersonDaoImpl personDaoImpl;

    @BeforeEach
    public void setUp() throws Exception {
        personDaoImpl = new PersonDaoImpl(listPersons);
    }

    @Test
    public void findAll() {

        List<Person> listPerson;
        listPerson = new ArrayList<Person>();
        listPerson = personDaoImpl.findAll();
        MatcherAssert.assertThat(listPerson.toString(), containsString("John"));
    }

}
