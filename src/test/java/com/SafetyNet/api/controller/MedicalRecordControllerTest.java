package com.SafetyNet.api.controller;

import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.service.MedicalRecordService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@WebMvcTest(MedicalRecordController.class)
public class MedicalRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicalRecordService medicalRecordService;

    @Test
    public void showAllMedicalRecords() throws Exception {

        MedicalRecord medicalRecord = new MedicalRecord();
        List<String>  medication    = new ArrayList<String>();
        List<String>  allergie      = new ArrayList<String>();
        allergie.add("AAAA");
        allergie.add("BBBB");
        medication.add("AAAA");
        medication.add("BBBB");
        List<MedicalRecord> listMedicalRecord = new ArrayList<MedicalRecord>();
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/1994");

        listMedicalRecord.add(medicalRecord);
        when(medicalRecordService.findAll()).thenReturn(listMedicalRecord);

        MvcResult mvcResult = mockMvc.perform(get("/medicalRecord")).andDo(print()).andReturn();
        int       status    = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(medicalRecordService, times(1)).findAll();
    }

    @Test
    public void showMedicalRecordById() throws Exception {
        // ARRANGE
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

        when(medicalRecordService.findById(any(String.class))).thenReturn(medicalRecord);

        // ACT
        MvcResult mvcResult = mockMvc.perform(get("/medicalRecord/Someone")).andDo(print()).andReturn();
        int       status    = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(medicalRecordService, times(1)).findById(any(String.class));
    }

    @Test
    public void addMedicalRecord() throws Exception {

        MedicalRecord       medicalRecord     = new MedicalRecord();
        List<MedicalRecord> listMedicalRecord = new ArrayList<MedicalRecord>();

        when(medicalRecordService.save(any(MedicalRecord.class))).thenReturn(listMedicalRecord);

        // ACT
        MvcResult mvcResult = mockMvc.perform(post("/medicalRecord").contentType(MediaType.APPLICATION_JSON)
                                                                    .content("{ \"firstName\":\"ghazi\", \"lastName\":\"bouzazi\", \"birthdate\":\"03/06/1984\", \"medications\":[\"aznol:350mg\", \"hydrapermazol:100mg\"], \"allergies\":[\"nillacilan\"] }"))
                                     .andDo(print())
                                     .andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(medicalRecordService, times(1)).save(any(MedicalRecord.class));
    }


    @Test
    public void updateMedicalRecord() throws Exception {
        // ARRANGE
        MedicalRecord medicalRecord = new MedicalRecord();
        List<String>  medication    = new ArrayList<String>();
        List<String>  allergie      = new ArrayList<String>();
        allergie.add("a1");
        allergie.add("a2");
        medication.add("a2");
        medication.add("q5");
        medicalRecord.setFirstName("ghazi");
        medicalRecord.setLastName("bouzazi");
        medicalRecord.setAllergies(allergie);
        medicalRecord.setMedications(medication);
        medicalRecord.setBirthdate("12/27/1994");
        when(medicalRecordService.update(any(String.class), (any(MedicalRecord.class)))).thenReturn(medicalRecord);

        // ACT
        MvcResult mvcResult = mockMvc.perform(put("/medicalRecord/ghazibouzazi").contentType(MediaType.APPLICATION_JSON)
                                                                                .content("{\"firstName\":\"ghazi\"}"))
                                     .andDo(print())
                                     .andReturn();
        int status = mvcResult.getResponse().getStatus();

        // ASSERT
        assertEquals(status, 200);
        verify(medicalRecordService, times(1)).update(any(String.class), (any(MedicalRecord.class)));
    }

    @Test
    public void deleteMedicalRecord() throws Exception {
        // ARRANGE
        Mockito.doNothing().when(medicalRecordService).deleteById("firstNameAndlastName");

        MvcResult mvcResult = mockMvc.perform(delete("/medicalRecord/ghazibouzazi")).andDo(print()).andReturn();
        int       status    = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(medicalRecordService, times(1)).deleteById(any(String.class));
    }
}
