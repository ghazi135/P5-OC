package com.SafetyNet.api.service;

import com.SafetyNet.api.dao.MedicalRecordDAO;
import com.SafetyNet.api.model.MedicalRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceTest {

    MedicalRecordService medicalRecordService;

    List<MedicalRecord> medicalRecordList;

    @Mock
    MedicalRecordDAO medicalRecordDAO;

    @BeforeEach
    void setup() {

        medicalRecordService = new MedicalRecordService(medicalRecordDAO);
    }

    @Test
    public void findAll() {

        medicalRecordList = new ArrayList<MedicalRecord>();
        MedicalRecord medicalRecord = new MedicalRecord();
        List<String>  medication    = new ArrayList<String>();
        List<String>  allergie      = new ArrayList<String>();
        allergie.add("AAAA");
        allergie.add("BBBB");
        medication.add("AAAA");
        medication.add("BBBB");
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/1994");

        medicalRecordList.add(medicalRecord);
        when(medicalRecordDAO.findAll()).thenReturn(medicalRecordList);
        assertThat(medicalRecordService.findAll().toString(), containsString("ghazi"));

    }

    @Test
    public void findById() {

        MedicalRecord medicalRecord = new MedicalRecord();
        List<String>  medication    = new ArrayList<String>();
        List<String>  allergie      = new ArrayList<String>();
        allergie.add("AAAA");
        allergie.add("BBBB");
        medication.add("AAAA");
        medication.add("BBBB");
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/1994");
        when(medicalRecordDAO.findById("ghazibouzazi")).thenReturn(medicalRecord);
        assertThat(medicalRecordService.findById("ghazibouzazi").toString(), containsString("ghazi"));

    }

    @Test
    public void saveMedicalRecordTest() {

        medicalRecordList = new ArrayList<MedicalRecord>();
        MedicalRecord medicalRecord = new MedicalRecord();
        List<String>  medication    = new ArrayList<String>();
        List<String>  allergie      = new ArrayList<String>();
        allergie.add("AAAA");
        allergie.add("BBBB");
        medication.add("AAAA");
        medication.add("BBBB");
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/1994");
        medicalRecordList.add(medicalRecord);
        when(medicalRecordDAO.save(medicalRecord)).thenReturn(medicalRecordList);
        assertThat(medicalRecordService.save(medicalRecord).toString(), containsString("ghazi"));

    }

    @Test
    public void updateMedicalRecordTest() throws ParseException {

        MedicalRecord medicalRecord = new MedicalRecord();
        List<String>  medication    = new ArrayList<String>();
        List<String>  allergie      = new ArrayList<String>();
        allergie.add("AAAA");
        allergie.add("BBBB");
        medication.add("AAAA");
        medication.add("BBBB");
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/1994");
        when(medicalRecordDAO.update("ghazibouzazi", medicalRecord)).thenReturn(medicalRecord);
        assertThat(medicalRecordService.update("ghazibouzazi", medicalRecord).toString(), containsString("ghazi"));

    }

    @Test
    public void deleteMedicalRecordTest() {

        MedicalRecord medicalRecord = new MedicalRecord();
        List<String>  medication    = new ArrayList<String>();
        List<String>  allergie      = new ArrayList<String>();
        allergie.add("AAAA");
        allergie.add("BBBB");
        medication.add("AAAA");
        medication.add("BBBB");
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/1994");
        medicalRecordDAO.save(medicalRecord);
        medicalRecordService.deleteById("ghazibouzazi");
        assertThat(medicalRecordService.findAll().toString(), containsString(""));

    }


}

