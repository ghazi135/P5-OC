package com.SafetyNet.api.dto;

import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class ChildrenByAdressDTO {


    @JsonIgnoreProperties({"address", "email", "city", "zip", "phone"})
    private final List<Person>        listPersons;
    @JsonIgnore
    private final  List<MedicalRecord> listMedicalRecords;
    private final  List<Long>          age;
    private static long                children;


    public ChildrenByAdressDTO(List<Person> listPersons, List<MedicalRecord> listMedicalRecords, List<Long> age, long children) {

        super();
        this.listPersons        = listPersons;
        this.listMedicalRecords = listMedicalRecords;
        this.age                = age;
        this.children           = children;
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

    public static long getChildren() {

        return children;
    }


}
