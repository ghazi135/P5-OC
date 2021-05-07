package com.SafetyNet.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MedicalRecord {

    private String       firstName;
    private String       lastName;
    private String       birthdate;
    private List<String> medications;
    private List<String> allergies;
    @JsonIgnore
    private String       firstNameAndlastName; // Unique requested identifier

    public MedicalRecord() {

    }

    public MedicalRecord(String firstName, String lastName, String birthdate, List<String> medications, List<String> allergies, String firstNameAndlastName) {

        this.firstName            = firstName;
        this.lastName             = lastName;
        this.birthdate            = birthdate;
        this.medications          = medications;
        this.allergies            = allergies;
        this.firstNameAndlastName = firstName + lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public Date getBirthdate() throws ParseException {

        Date date1 =new SimpleDateFormat("MM/dd/yyyy").parse(birthdate);
        return date1;
    }

    public void setBirthdate(String birthdate) {

        this.birthdate = birthdate;
    }

    public List<String> getMedications() {

        return medications;
    }

    public void setMedications(List<String> medications) {

        this.medications = medications;
    }

    public List<String> getAllergies() {

        return allergies;
    }

    public void setAllergies(List<String> allergies) {

        this.allergies = allergies;
    }

    public String getFirstNameAndlastName() {

        return firstName + lastName;
    }

    @Override
    public String toString() {

        return "MedicalRecords [firstName=" + firstName + ", lastName=" + lastName + ", birthdate=" + birthdate + ", medications=" + medications + ", allergies=" + allergies + "]";
    }

}
