package com.SafetyNet.api.daoTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.SafetyNet.api.dao.MedicalRecordDAOImpl;
import com.SafetyNet.api.model.MedicalRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MedicalRecordDAOTest {

    private List<MedicalRecord>  medicalRecords;
    private MedicalRecordDAOImpl medicalRecordImpl;

    @BeforeEach
    public void setUp() throws Exception {
        medicalRecordImpl = new MedicalRecordDAOImpl(medicalRecords);
    }

    @Test
    public void findAll() {

        List<MedicalRecord> listMedicalRecord = new ArrayList<MedicalRecord>(); // method return value

        listMedicalRecord = medicalRecordImpl.findAll();

        assertThat(listMedicalRecord.toString(), containsString("John"));
    }

    @Test
    public void findId() {

        MedicalRecord medicalRecord = new MedicalRecord();
        String firstNameAndlastName = "JohnBoyd"; // parameter

        medicalRecord = medicalRecordImpl.findById(firstNameAndlastName);

        assertThat(medicalRecord.getFirstName(), containsString("John"));
    }

    @Test
    public void findByFirstName() {

        MedicalRecord medicalRecord = new MedicalRecord();
        String firstName = "John";

        medicalRecord = medicalRecordImpl.findByFirstName(firstName);
        assertThat(medicalRecord.getFirstName(), containsString("John"));
    }

    @Test
    public void findByLastName() {

        List<MedicalRecord> medicalRecord = new ArrayList<MedicalRecord>();
        String lastName = "Boyd"; // parameter
        medicalRecord = medicalRecordImpl.findByLastName(lastName);

        assertThat(medicalRecord.toString(), containsString("John"));
        assertThat(medicalRecord.toString(), containsString("Allison"));
    }

    @Test
    public void save() {
        // ARRANGE
        MedicalRecord medicalRecord = new MedicalRecord();
        List<String> allergies = new ArrayList<String>();
        allergies.add("BBBB");
        medicalRecord.setFirstName("AAAA");
        medicalRecord.setAllergies(allergies);
        // ACT
        medicalRecordImpl.save(medicalRecord);
        // ASSERT
        medicalRecords = medicalRecordImpl.findAll();
        assertThat(medicalRecords.toString(), containsString("AAAA"));
        assertThat(medicalRecords.toString(), containsString("BBBB"));
    }

    @Test
    public void update() throws ParseException {
        // ARRANGE
        MedicalRecord medicalRecord = new MedicalRecord();
        String firstNameAndlastName = "JohnBoyd";
        List<String> allergies = new ArrayList<String>();
        allergies.add("BBBB");
        medicalRecord.setFirstName("AAAA");
        medicalRecord.setAllergies(allergies);
        medicalRecord.setBirthdate("03/25/1995");
        medicalRecordImpl.update(firstNameAndlastName, medicalRecord);

        medicalRecords = medicalRecordImpl.findAll();
        assertThat(medicalRecords.toString(), containsString("BBBB"));
        assertThat(medicalRecords.toString(), not(containsString("AAAA")));
    }

    @Test
    public void delete() {
        // ARRANGE
        String firstNameAndlastName = "JohnBoyd"; // parameter
        // ACT
        medicalRecordImpl.deleteById(firstNameAndlastName);
        // ASSERT
        medicalRecords = medicalRecordImpl.findAll();
        assertThat(medicalRecords.toString(), not(containsString("John")));
    }
}
