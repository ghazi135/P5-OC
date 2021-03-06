package com.SafetyNet.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Person {


    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String email;
    private int    zip;
    private String phone;
    @JsonIgnore
    private String firstNameAndlastName;

    public Person() {

    }

    public Person(String firstName, String lastName, String address, String city, int zip, String phone, String email, String firstNameAndlastName) {

        super();
        this.firstName            = firstName;
        this.lastName             = lastName;
        this.address              = address;
        this.city                 = city;
        this.zip                  = zip;
        this.phone                = phone;
        this.email                = email;
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

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public int getZip() {

        return zip;
    }

    public void setZip(int zip) {

        this.zip = zip;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getfirstNameAndlastName() {

        return firstName + lastName;
    }

    @Override
    public String toString() {

        return "Persons [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city + ", zip=" + zip + ", phone=" + phone + ", email=" + email + "]";
    }

}
