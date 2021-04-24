package com.SafetyNet.api.controller;

import com.SafetyNet.api.Model.Person;
import com.SafetyNet.api.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(PersonController.class);
    @Autowired
    private              ObjectMapper                    mapper;
    @Autowired
    private              PersonService                   personService;

    @GetMapping(value = "/person")
    public String showAllPersons() throws Exception {

        return mapper.writeValueAsString(personService.findAll());
    }


    @GetMapping(value = "/person/{firstNameAndlastName}")
    public Person showPersonById(@PathVariable String firstNameAndlastName) throws Exception {


        return personService.findById(firstNameAndlastName);
    }

    @PostMapping(value = "/person")
    public List<Person> addPerson(@RequestBody Person person) throws Exception {

        List<Person> personList = personService.save(person);

        return personList;


    }

    @PutMapping(value = "/person/{firstNameAndlastName}")
    public Person updatePerson(@RequestBody Person person, @PathVariable String firstNameAndlastName) throws Exception {

        Person personUpdated = personService.update(firstNameAndlastName, person);

        return personUpdated;
    }


    @DeleteMapping(value = "/person/{firstNameAndlastName}")
    public List<Person> deletePerson(@PathVariable String firstNameAndlastName) throws Exception {
      return   personService.deleteById(firstNameAndlastName);

    }
}

