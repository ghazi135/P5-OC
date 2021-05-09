package com.SafetyNet.api.DTO;

import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;

import java.util.List;

public class PersonsAddressByFirestationDTO {

    private final List<Person>        listPersons;
    private final List<MedicalRecord> listMedicalRecords;
    private final List<Long>          age;



    public PersonsAddressByFirestationDTO(List<Person> listPersons, List<MedicalRecord> listMedicalRecords, List<Long> age) {

        this.listPersons = listPersons;
        this.listMedicalRecords      = listMedicalRecords;
        this.age    = age;
    }

    public List<Person> getListPersons() {

        return listPersons;
    }

    public List<MedicalRecord> getListMedicalRecords() {

        return listMedicalRecords;
    }

    public List<Long> getAge() {

        return age;
    }

}
