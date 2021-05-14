package com.SafetyNet.api.dto;

import com.SafetyNet.api.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class PersonByFirestationDTO {

    @JsonIgnoreProperties({"zip", "email", "city"})
    private final List<Person> listPersons;
    private final long         adults;
    private final long         children;


    public PersonByFirestationDTO(List<Person> listPersons, long adults, long children) {

        this.listPersons = listPersons;
        this.adults      = adults;
        this.children    = children;
    }

    public List<Person> getListPersons() {

        return listPersons;
    }

    public long getAdults() {

        return adults;
    }

    public long getChildren() {

        return children;
    }


}
