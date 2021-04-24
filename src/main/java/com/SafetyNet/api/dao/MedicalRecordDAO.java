package com.SafetyNet.api.dao;

import com.SafetyNet.api.Model.MedicalRecord;

import java.util.List;

public interface MedicalRecordDAO {

    public List<MedicalRecord> findAll();

    public MedicalRecord findById(String firstNameAndlastName);

    public MedicalRecord findByFirstName(String firstName);

    public List<MedicalRecord> findByLastName(String lastName);

    public List<MedicalRecord> save(MedicalRecord medicalRecord);

    public MedicalRecord update(String firstNameAndlastName, MedicalRecord medicalRecord);

    public void deleteById(String firstNameAndlastName);
}
