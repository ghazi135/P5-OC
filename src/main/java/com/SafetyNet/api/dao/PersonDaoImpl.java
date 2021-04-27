package com.SafetyNet.api.dao;
import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.json.DataReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    private List<Person> persons;

    public PersonDaoImpl() {

    }
    @Autowired
    public PersonDaoImpl(List<Person> person) throws Exception {
        super();
        person       = new DataReaderService().getData().getPersons();
        this.persons = person;
    }

    @Override
    public List<Person> findAll() {

        return persons;
    }

    @Override
    public Person findById(String firstNameAndlastName) {

        for (Person person : persons) {
            if ((person.getfirstNameAndlastName()).equals(firstNameAndlastName)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> findByLastName(String lastName) {

        List<Person> listPerson = new ArrayList<Person>();
        for (Person person : persons) {
            if ((person.getLastName()).equals(lastName)) {
                listPerson.add(person);
            }
        }
        return listPerson;
    }

    @Override
    public List<Person> findByAddress(String address) {

        List<Person> listPerson = new ArrayList<Person>();
        for (Person person : persons) {
            if ((person.getAddress()).equals(address)) {
                listPerson.add(person);
            }
        }
        return listPerson;
    }

    @Override
    public List<Person> findEmailByCity(String city) {

        List<Person> listPerson = new ArrayList<Person>();
        for (Person person : persons) {
            if ((person.getCity()).equals(city)) {
                listPerson.add(person);
            }
        }
        return listPerson;
    }

    @Override
    public List<Person> save(Person person) {

        List<Person> savePerson = persons;
        savePerson.add(person);
        return savePerson;
    }

    @Override
    public Person update(String firstNameAndlastName, Person person) {

        for (Person updatePerson : persons) {
            if ((updatePerson.getfirstNameAndlastName()).equals(firstNameAndlastName)) {
                updatePerson.setAddress(person.getAddress());
                updatePerson.setCity(person.getCity());
                updatePerson.setEmail(person.getEmail());
                updatePerson.setPhone(person.getPhone());
                updatePerson.setZip(person.getZip());
                return updatePerson;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String firstNameAndlastName) {

        List<Person> deletePerson = persons;
        deletePerson.removeIf(person -> person.getfirstNameAndlastName().equals(firstNameAndlastName));
    }
}
