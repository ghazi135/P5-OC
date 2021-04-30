package com.SafetyNet.api.service;

import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {


    @Autowired
    private PersonDao personDAO ;


    public List<Person> findAll()  {


        return personDAO.findAll();
    }

    public Person findById(String address)  {

        return  personDAO.findById(address);
    }
//
    public List<Person> save(Person person)  {

        personDAO.save(person);

        return  personDAO.findAll();
    }
//
    public Person update(String address, Person person)  {

        return personDAO.update(address, person);
    }

    public List<Person> deleteById(String id)  {

        personDAO.deleteById(id);
        return personDAO.findAll();
    }
}
