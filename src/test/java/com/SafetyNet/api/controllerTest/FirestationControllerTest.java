package com.SafetyNet.api.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.service.FirestationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.SafetyNet.api.controller.FirestationController;

@WebMvcTest(FirestationController.class)
public class FirestationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirestationService firestationService;

    @Test
    public void showAllFirestations() throws Exception {
        Firestation firestation = new Firestation();
        firestation.setStation(10);
        firestation.setAddress("15 rue colonel dumont ");
        List<Firestation> listFirestation = new ArrayList<Firestation>();
        listFirestation.add(firestation);
        when(firestationService.findAll()).thenReturn(listFirestation);

        MvcResult mvcResult = mockMvc.perform(get("/firestation/")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(status, 200);
        verify(firestationService, times(1)).findAll();
    }

    @Test
    public void showFirestationById() throws Exception {

        Firestation firestation = new Firestation();
        firestation.setStation(10);
        firestation.setAddress("15 rue colonel dumont ");
        when(firestationService.findById(any(String.class))).thenReturn(firestation);

        MvcResult mvcResult = mockMvc.perform(get("/firestation/Somewhere")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(firestationService, times(1)).findById(any(String.class));
    }

    @Test
    public void addFirestation() throws Exception {
        Firestation firestation = new Firestation();
        firestation.setStation(10);
        firestation.setAddress("15 rue colonel dumont ");
        List<Firestation> listFirestation = new ArrayList<Firestation>();
        when(firestationService.save(any(Firestation.class))).thenReturn(listFirestation);

        // ACT
        MvcResult mvcResult = mockMvc
                .perform(post("/firestation").contentType(MediaType.APPLICATION_JSON).content("{ \"address\":\"15 rue colonel dumont\", \"station\":\"10\" }"))
                .andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        // ASSERT
        assertEquals(status, 200);
        verify(firestationService, times(1)).save((any(Firestation.class)));
    }

    @Test
    public void updateFirestation() throws Exception {
        Firestation firestation = new Firestation();
        firestation.setStation(10);
        firestation.setAddress("15 rue colonel dumont ");
        when(firestationService.update(any(String.class), any(Firestation.class))).thenReturn(firestation);

        // ACT
        MvcResult mvcResult = mockMvc.perform(
                put("/firestation/Somewhere").contentType(MediaType.APPLICATION_JSON).content("{\"address\":\"15 rue colonel dumont\"}"))
                                     .andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        // ASSERT
        assertEquals(status, 200);
        verify(firestationService, times(1)).update(any(String.class), any(Firestation.class));
    }

    @Test
    public void deleteFirestation() throws Exception {

        MvcResult mvcResult = mockMvc.perform(delete("/firestation/Somewhere")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(firestationService, times(1)).deleteById(any(String.class));
    }
}
