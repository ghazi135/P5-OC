package com.SafetyNet.api.controller;

import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class PersonController {



    @Autowired
    private PersonService personService;

    @GetMapping(value = "/person")
    public List<Person> showAllPersons() {

        log.info("GET: /person");
        return personService.findAll();
    }


    @GetMapping(value = "/person/{firstNameAndLastName}")
    public Person showPersonById(@PathVariable String firstNameAndLastName) {

        log.info("GET: /person/{firstNameAndLastName}");
        return personService.findById(firstNameAndLastName);
    }

    @PostMapping(value = "/person")
    public List<Person> addPerson(@RequestBody Person person) {

        log.info("post: /person");

        return personService.save(person);

    }

    @PutMapping(value = "/person/{firstNameAndLastName}")
    public Person updatePerson(@RequestBody Person person, @PathVariable String firstNameAndLastName) {

        log.info("post: /person/{firstNameAndLastName}");

        return personService.update(firstNameAndLastName, person);
    }


    @DeleteMapping(value = "/person/{firstNameAndLastName}")
    public List<Person> deletePerson(@PathVariable String firstNameAndLastName) {

        log.info("delete: /person/{firstNameAndLastName}");
        return personService.deleteById(firstNameAndLastName);

    }
}

