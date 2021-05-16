package com.SafetyNet.api.service;

import com.SafetyNet.api.dao.PersonDAO;
import com.SafetyNet.api.model.Person;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class PersonService {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(PersonService.class);

    @Autowired
    private final PersonDAO personDAO;

    @Autowired
    public PersonService(PersonDAO personDAO) {

        this.personDAO = personDAO;
    }

    public List<Person> findAll() {

        log.info("find all persons");


        return personDAO.findAll();
    }

    public Person findById(String address) {

        log.info("find  person by id ");
        return personDAO.findById(address);
    }

    //
    public List<Person> save(Person person) {

        log.info("save person ");

        personDAO.save(person);

        return personDAO.findAll();
    }

    //
    public Person update(String address, Person person) {

        log.info("update person by id ");

        return personDAO.update(address, person);
    }

    public List<Person> deleteById(String id) {

        log.info("delete person by id ");
        personDAO.deleteById(id);
        return personDAO.findAll();
    }
}
