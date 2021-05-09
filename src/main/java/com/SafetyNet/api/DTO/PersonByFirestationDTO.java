package com.SafetyNet.api.DTO;

import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;

import java.util.List;

public class PersonByFirestationDTO {

    private final List<Person> listPersons;
    private final long adults;
    private final long children;




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
