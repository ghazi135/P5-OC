package com.SafetyNet.api.serviceTest;

import com.SafetyNet.api.dao.FirestationDAO;
import com.SafetyNet.api.dao.MedicalRecordDAO;
import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.service.FirestationService;
import com.SafetyNet.api.service.MedicalRecordService;
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
        void setup(){
            medicalRecordService = new MedicalRecordService(medicalRecordDAO);
        }

        @Test
        public void findAll(){
            medicalRecordList = new ArrayList<MedicalRecord>();
            MedicalRecord medicalRecord = new MedicalRecord();
            List<String> medication = new ArrayList<String>();
            List<String> allergie = new ArrayList<String>();
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
            when(medicalRecordService.findAll()).thenReturn(medicalRecordList);
            assertThat(medicalRecordService.findAll().toString(), containsString("ghazi"));

        }

        @Test
        public void findById(){
            MedicalRecord medicalRecord = new MedicalRecord();
            List<String> medication = new ArrayList<String>();
            List<String> allergie = new ArrayList<String>();
            allergie.add("AAAA");
            allergie.add("BBBB");
            medication.add("AAAA");
            medication.add("BBBB");
            medicalRecord.setFirstName("ghazi");
            medicalRecord.setLastName("bouzazi");
            medicalRecord.setAllergies(allergie);
            medicalRecord.setMedications(medication);
            medicalRecord.setBirthdate("12/27/1994");
            when(medicalRecordService.findById("ghazibouzazi")).thenReturn(medicalRecord);
            assertThat(medicalRecordService.findById("ghazibouzazi").toString(), containsString("ghazi"));

        }

        @Test
        public void saveMedicalRecordTest(){
            medicalRecordList = new ArrayList<MedicalRecord>();
            MedicalRecord medicalRecord = new MedicalRecord();
            List<String> medication = new ArrayList<String>();
            List<String> allergie = new ArrayList<String>();
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
            when(medicalRecordService.save(medicalRecord)).thenReturn(medicalRecordList);
            assertThat(medicalRecordService.save(medicalRecord).toString(), containsString("ghazi"));

        }

        @Test
        public void updateMedicalRecordTest() throws ParseException {
            MedicalRecord medicalRecord = new MedicalRecord();
            List<String> medication = new ArrayList<String>();
            List<String> allergie = new ArrayList<String>();
            allergie.add("AAAA");
            allergie.add("BBBB");
            medication.add("AAAA");
            medication.add("BBBB");
            medicalRecord.setFirstName("ghazi");
            medicalRecord.setLastName("bouzazi");
            medicalRecord.setAllergies(allergie);
            medicalRecord.setMedications(medication);
            medicalRecord.setBirthdate("12/27/1994");
            when(medicalRecordService.update("ghazibouzazi", medicalRecord)).thenReturn(medicalRecord);
            assertThat(medicalRecordService.update("ghazibouzazi",medicalRecord).toString(), containsString("ghazi"));

        }

        @Test
        public void deleteMedicalRecordTest(){
            MedicalRecord medicalRecord = new MedicalRecord();
            List<String> medication = new ArrayList<String>();
            List<String> allergie = new ArrayList<String>();
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

