package com.SafetyNet.api.dto;

import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class ListPersonByAdressDTO {
    @JsonIgnoreProperties({"address", "email", "city", "zip"})
    List<Person> personList;
    @JsonIgnoreProperties({"lastName", "firstName", "birthdate"})
    List<MedicalRecord> medicalRecordList;
    @JsonIgnoreProperties({"address"})
    Firestation firestation;
    List<Long>  agesList;


    public ListPersonByAdressDTO(List<Person> personList, List<MedicalRecord> medicalRecordList, Firestation firestation, List<Long> agesList) {

        this.personList = personList;
        this.medicalRecordList = medicalRecordList;
        this.firestation = firestation;
        this.agesList = agesList;
    }

    public List<Person> getPersonList() {

        return personList;
    }

    public List<MedicalRecord> getMedicalRecordList() {

        return medicalRecordList;
    }

    public Firestation getFirestation() {

        return firestation;
    }

    public List<Long> getAgesList() {

        return agesList;
    }

}
