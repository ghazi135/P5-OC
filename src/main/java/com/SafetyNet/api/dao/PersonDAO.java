package com.SafetyNet.api.dao;

import com.SafetyNet.api.model.Person;

import java.util.List;

public interface PersonDAO {

    public List<Person> findAll();

    public Person findById(String firstNameAndlastName);

    public List<Person> findByAddress(String address);

    public List<Person> findEmailByCity(String city);

    public List<Person> save(Person person);

    public Person update(String firstNameAndlastName, Person person);

    public void deleteById(String firstNameAndlastName);

}
