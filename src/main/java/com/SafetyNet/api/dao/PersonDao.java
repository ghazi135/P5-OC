package com.SafetyNet.api.dao;

import com.SafetyNet.api.Model.Person;

import java.util.List;

public interface PersonDao {

    public List<Person> findAll();

    public Person findById(String firstNameAndlastName);

    public List<Person> findByLastName(String lastName);

    public List<Person> findByAddress(String address);

    public List<Person> findEmailByCity(String city);

    public List<Person> save(Person person);

    public Person update(String firstNameAndlastName, Person person);

    public void deleteById(String firstNameAndlastName);

}
