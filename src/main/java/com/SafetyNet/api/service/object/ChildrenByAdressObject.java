package com.SafetyNet.api.service.object;

import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;

import java.util.List;

public class ChildrenByAdressObject {



    private List<Person>        listPersons;
    private List<MedicalRecord> listMedicalRecords;
    private List<Long>          age;



    private static long children;


    public ChildrenByAdressObject(List<Person> listPersons, List<MedicalRecord> listMedicalRecords, List<Long> age,
            long children) {
        super();
        this.listPersons = listPersons;
        this.listMedicalRecords = listMedicalRecords;
        this.age = age;
        this.children = children;
    }


    public List<Person> getListPersons() {

        return listPersons;
    }

    public List<MedicalRecord> getListMedicalRecords() {

        return listMedicalRecords;
    }

    public List<Long> getAge() {

        return age;
    }
    public static long getChildren() {

        return children;
    }


}