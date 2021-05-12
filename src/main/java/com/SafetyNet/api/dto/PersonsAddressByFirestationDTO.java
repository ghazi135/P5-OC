package com.SafetyNet.api.dto;

import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;

import java.util.List;

public class PersonsAddressByFirestationDTO {




    private final int          station;
    private final String       lastName;
    private final String       phone;
    private final Long         age;
    private final List<String> medications;
    private final List<String> allergies;


    public PersonsAddressByFirestationDTO(int station, String lastName, String phone, Long age, List<String> medications, List<String> allergies) {

        this.station = station;
        this.lastName    = lastName;
        this.phone       = phone;
        this.age         = age;
        this.medications = medications;
        this.allergies   = allergies;
    }

    public int getStation() {

        return station;
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
