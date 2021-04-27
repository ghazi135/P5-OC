package com.SafetyNet.api.controller;

import com.SafetyNet.api.model.Person;
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


    @GetMapping(value = "/person/{firstNameAndLastName}")
    public Person showPersonById(@PathVariable String firstNameAndLastName) {


        return personService.findById(firstNameAndLastName);
    }

    @PostMapping(value = "/person")
    public List<Person> addPerson(@RequestBody Person person) {

        return personService.save(person);

    }

    @PutMapping(value = "/person/{firstNameAndLastName}")
    public Person updatePerson(@RequestBody Person person, @PathVariable String firstNameAndLastName) {


        return personService.update(firstNameAndLastName, person);
    }


    @DeleteMapping(value = "/person/{firstNameAndLastName}")
    public List<Person> deletePerson(@PathVariable String firstNameAndLastName) {

        return personService.deleteById(firstNameAndLastName);

    }
}

