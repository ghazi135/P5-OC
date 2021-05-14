package com.SafetyNet.api.dto;

public class ChildrenByAdressDTO {


    private final String firstName;
    private final String lastName;
    private final Long   age;

    public ChildrenByAdressDTO(String firstName, String lastName, Long age) {

        this.firstName = firstName;
        this.lastName  = lastName;
        this.age       = age;
    }


    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public Long getAge() {

        return age;
    }
}
