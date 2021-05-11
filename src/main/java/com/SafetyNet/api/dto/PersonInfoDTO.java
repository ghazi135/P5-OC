package com.SafetyNet.api.dto;

import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class PersonInfoDTO {
    @JsonIgnoreProperties({"firstName", "city", "zip", "phone"})
    private final List<Person>        listPersons;
    @JsonIgnoreProperties({"firstName","lastName","birthdate"})
    private final List<MedicalRecord> listMedicalRecords;
    private final List<Long>          age;

    public PersonInfoDTO(List<Person> listPersons, List<MedicalRecord> listMedicalRecords, List<Long> age) {

        this.listPersons        = listPersons;
        this.listMedicalRecords = listMedicalRecords;
        this.age = age;

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
