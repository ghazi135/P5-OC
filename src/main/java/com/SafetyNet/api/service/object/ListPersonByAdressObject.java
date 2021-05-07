package com.SafetyNet.api.service.object;

import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;

import java.util.List;

public class ListPersonByAdressObject {

    List<Person> personList;
    List<MedicalRecord> medicalRecordList;
    Firestation firestation;
    List<Long>  agesList;


    public ListPersonByAdressObject(List<Person> personList, List<MedicalRecord> medicalRecordList, Firestation firestation, List<Long> agesList) {

        this.personList = personList;
        this.medicalRecordList = medicalRecordList;
        this.firestation = firestation;
        this.agesList = agesList;
    }

    public List<Person> getPersonList() {

        return personList;
    }

    public List<MedicalRecord> getMedicalRecordList() {

        return medicalRecordList;
    }

    public Firestation getFirestation() {

        return firestation;
    }

    public List<Long> getAgesList() {

        return agesList;
    }

}
