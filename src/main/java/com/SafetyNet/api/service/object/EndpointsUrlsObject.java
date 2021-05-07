package com.SafetyNet.api.service.object;


import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;

import java.util.List;

public class EndpointsUrlsObject {

    private List<String>        email;
    private List<Person>        listPersons;
    private List<MedicalRecord> listMedicalRecords;
    private Firestation         firestations;
    private long                adults;
    private long                children;
    private List<Long>          age;


    public EndpointsUrlsObject(List<String> email) {

        this.email = email;
    }


    public EndpointsUrlsObject(List<Person> listPersons, long adults, long children) {

        this.listPersons = listPersons;
        this.adults      = adults;
        this.children    = children;
    }

    public List<Person> getListPersons() {

        return listPersons;
    }

    public List<MedicalRecord> getListMedicalRecords() {

        return listMedicalRecords;
    }

    public Firestation getFirestations() {

        return firestations;
    }

    public long getAdults() {

        return adults;
    }

    public long getChildren() {

        return children;
    }

    public List<Long> getAge() {

        return age;
    }


    public List<String> getEmail() {

        return email;
    }

}
