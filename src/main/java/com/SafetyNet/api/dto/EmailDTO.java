package com.SafetyNet.api.dto;


import java.util.List;

public class EmailDTO {

    private final List<String> email;



    public EmailDTO(List<String> email) {

        this.email = email;
    }


    public List<String> getEmail() {

        return email;
    }

}
