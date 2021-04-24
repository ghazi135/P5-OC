package com.SafetyNet.api.service;

import com.SafetyNet.api.Model.Person;
import com.SafetyNet.api.dao.PersonDao;
import com.SafetyNet.api.dao.PersonDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDAO ;



    public List<Person> findAll() throws Exception {
        List<Person> listPersons = null;

        personDAO = new PersonDaoImpl(listPersons);
        listPersons = personDAO.findAll();

        return listPersons;
    }

    public Person findById(String address) throws Exception {
        Person person = new Person();
        List<Person> listPersons = null;
        personDAO = new PersonDaoImpl(listPersons);
        person = personDAO.findById(address);

        return  person;
    }

    public List<Person> save(Person person) throws Exception {

        List<Person> listPerson = null;
        personDAO = new PersonDaoImpl(listPerson);
        listPerson = personDAO.save(person);
        return listPerson;
    }

    public Person update(String address, Person person) throws Exception {
        List<Person> listPerson = null;
        personDAO = new PersonDaoImpl(listPerson);
        return personDAO.update(address, person);
    }

    public List<Person> deleteById(String id) throws Exception {
        List<Person> listPerson = null;
        personDAO = new PersonDaoImpl(listPerson);
        personDAO.deleteById(id);
        return personDAO.findAll();
    }
}
