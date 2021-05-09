package com.SafetyNet.api.DTO;


import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;

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
