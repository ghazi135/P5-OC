package com.SafetyNet.api.json;


import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;

import java.util.List;

public class DataReader {

    private List<Person>        persons;
    private List<Firestation>   firestations;
    private List<MedicalRecord> medicalRecords;

    public DataReader() {

    }

    public DataReader(List<Person> person, List<Firestation> firestation, List<MedicalRecord> medicalRecord) {

        this.persons        = person;
        this.firestations   = firestation;
        this.medicalRecords = medicalRecord;
    }


    public List<Person> getPersons() {

        return persons;
    }

    public void setPersons(List<Person> person) {

        this.persons = person;
    }

    public List<Firestation> getFirestations() {

        return firestations;
    }

    public void setFirestations(List<Firestation> firestation) {

        this.firestations = firestation;
    }

    public List<MedicalRecord> getMedicalRecords() {

        return medicalRecords;
    }

    public void setMedicalrecords(List<MedicalRecord> medicalRecord) {

        this.medicalRecords = medicalRecord;
    }

    @Override
    public String toString() {

        return "JSONDataObject [persons=" + persons + ", firestations=" + firestations + ", medicalRecords=" + medicalRecords + "]";
    }
}
