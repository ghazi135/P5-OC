package com.SafetyNet.api.service;


import com.SafetyNet.api.dao.MedicalRecordDAO;
import com.SafetyNet.api.dao.MedicalRecordDAOImpl;
import com.SafetyNet.api.model.MedicalRecord;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgeTest {

    MedicalRecordDAO medicalRecordDAO;
    private Ages ages = new Ages();

    @Test
    void givenABirthDate_whenCalculateDate_thenItGetTheAge() {
        // ARRANGE
        Calendar birthdate1 = Calendar.getInstance();
        Calendar birthdate2 = Calendar.getInstance();

        birthdate1.set(2010, 01, 01);
        Date birthDateChild = birthdate1.getTime();
        birthdate2.set(2000, 01, 01);
        Date birthDateAdult = birthdate2.getTime();

        // ACT
        ages.calculateDate(birthDateChild);
        long ageChild = ages.getAge();
        ages.calculateDate(birthDateAdult);
        long ageAdult = ages.getAge();

        // ASSERT
        assertEquals(ageChild, 11);
        assertEquals(ageAdult, 21);
    }

    @Test
    void givenChildrenBirthDates_whenCalculateDate_thenItCountTheNumberOfChildren() {
        // ARRANGE
        Calendar child1 = Calendar.getInstance();
        Calendar child2 = Calendar.getInstance();

        child1.set(2010, 10, 10);
        Date birthDate1 = child1.getTime();
        child2.set(2019, 9, 9);
        Date birthDate2 = child2.getTime();

        // ACT
        ages.calculateDate(birthDate1);
        ages.calculateDate(birthDate2);
        long children = ages.getChildren();
        long adults   = ages.getAdults();

        // ASSERT
        assertEquals(children, 2);
        assertEquals(adults, 0);
    }

    @Test
    void givenAdultsBirthDates_whenCalculateDate_thenItCountTheNumberOfAdults() {
        // ARRANGE
        Calendar adult1 = Calendar.getInstance();
        Calendar adult2 = Calendar.getInstance();

        adult1.set(2000, 01, 01);
        Date birthDate1 = adult1.getTime();
        adult2.set(1950, 5, 5);
        Date birthDate2 = adult2.getTime();

        // ACT
        ages.calculateDate(birthDate1);
        ages.calculateDate(birthDate2);
        long adults   = ages.getAdults();
        long children = ages.getChildren();

        // ASSERT
        assertEquals(adults, 2);
        assertEquals(children, 0);

    }

    @Test
    void givenBirthDatesFromJSON_whenCalculateDate_thenItCountTheNumberOfAdultsAndChildren() throws Exception {
        // ARRANGE

        List<MedicalRecord> listMedicalRecords = new ArrayList<MedicalRecord>();
        medicalRecordDAO = new MedicalRecordDAOImpl(listMedicalRecords);
        // ACT
        for (MedicalRecord medicalRecord : medicalRecordDAO.findAll()) {
            ages.calculateDate(new SimpleDateFormat("MM/dd/yyyy").parse(medicalRecord.getBirthdate()));
        }
        long adults   = ages.getAdults();
        long children = ages.getChildren();

        // ASSERT
        assertEquals(adults, 18);
        assertEquals(children, 5);

    }

    @Test
    void givenBirthDatesFromJSON_whenCalculateDate_thenItGiveTheAgeOfAdultsAndChildren() throws Exception {

        List<MedicalRecord> listMedicalRecords = new ArrayList<MedicalRecord>();
        medicalRecordDAO = new MedicalRecordDAOImpl(listMedicalRecords);

        for (MedicalRecord medicalRecord : medicalRecordDAO.findAll()) {
            ages.calculateDate(new SimpleDateFormat("MM/dd/yyyy").parse(medicalRecord.getBirthdate()));
        }
        long ageOfTheLastRecord = ages.getAge();


        assertEquals(ageOfTheLastRecord, 75);

    }
}

