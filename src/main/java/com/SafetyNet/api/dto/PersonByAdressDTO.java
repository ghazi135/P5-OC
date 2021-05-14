package com.SafetyNet.api.dto;

import com.SafetyNet.api.model.MedicalRecord;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PersonByAdressDTO {


    String firstName;
    String lastName;
    Long   age;
    String phone;
    int    firestationNumber;
    @JsonIgnoreProperties({"lastName", "firstName", "birthdate"})
    MedicalRecord medicalRecord;

    public PersonByAdressDTO(String firstName, String lastName, Long age, String phone, int firestationNumber, MedicalRecord medicalRecord) {

        this.firstName         = firstName;
        this.lastName          = lastName;
        this.age               = age;
        this.phone             = phone;
        this.firestationNumber = firestationNumber;
        this.medicalRecord     = medicalRecord;
    }


    public MedicalRecord getMedicalRecord() {

        return medicalRecord;
    }


    public String getFirstname() {

        return firstName;
    }

    public Long getAge() {

        return age;
    }

    public String getPhone() {

        return phone;
    }

    public int getFirestationNumber() {

        return firestationNumber;
    }


}
