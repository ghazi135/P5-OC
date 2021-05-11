package com.SafetyNet.api.dto;

import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;

import java.util.List;

public class PersonsAddressByFirestationDTO {

    private final String       lastName;
    private final String       phone;
    private final Long         age;
    private final List<String> medications;
    private final List<String> allergies;


    public PersonsAddressByFirestationDTO(String lastName, String phone, Long age, List<String> medications, List<String> allergies) {

        this.lastName    = lastName;
        this.phone       = phone;
        this.age         = age;
        this.medications = medications;
        this.allergies   = allergies;
    }

    public String getLastName() {

        return lastName;
    }

    public String getPhone() {

        return phone;
    }

    public Long getAge() {

        return age;
    }

    public List<String> getMedications() {

        return medications;
    }

    public List<String> getAllergies() {

        return allergies;
    }





}
