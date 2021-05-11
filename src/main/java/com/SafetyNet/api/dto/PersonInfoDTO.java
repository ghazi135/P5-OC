package com.SafetyNet.api.dto;


import java.util.List;

public class PersonInfoDTO {

    private  String       lastName;
    private  String       address;
    private Long         age;
    private String       email;
    private List<String> medications;
    private List<String> allergies;


    public PersonInfoDTO( String lastName, String address, String email, Long age,List<String> medications, List<String> allergies) {

        this.lastName             = lastName;
        this.address              = address;
        this.email                = email;
        this.age   = age;
        this.medications = medications;
        this.allergies   = allergies;
    }


    public String getLastName() {

        return lastName;
    }

    public Long getAge() {

        return age;
    }


    public String getAddress() {

        return address;
    }


    public String getEmail() {

        return email;
    }
    public List<String> getMedications() {

        return medications;
    }

    public List<String> getAllergies() {

        return allergies;
    }


}
