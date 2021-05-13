package com.SafetyNet.api.controller;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

import com.SafetyNet.api.dto.*;
import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.service.EndpointUrlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(EndpointsUrlController.class)
public class EndpointsURLsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EndpointUrlService endpointUrlService;

    @Test
    public void getPersonsByFirestation() throws Exception {

        List<Person> listPersons = new ArrayList<Person>();
        long         children    = 0;
        long                   adults                  = 0;
        PersonByFirestationDTO personByFirestationDTO = new PersonByFirestationDTO(listPersons, adults, children);
        when(endpointUrlService.getPersonsByFirestation(any(int.class))).thenReturn(personByFirestationDTO);

        MvcResult mvcResult = this.mockMvc.perform(get("/firestation?stationNumber=0")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(endpointUrlService, times(1)).getPersonsByFirestation(any(int.class));
    }

    @Test
    public void getChildrenByAddress() throws Exception {

       List<ChildrenByAdressDTO> childrenByAdressDTOList = new ArrayList<ChildrenByAdressDTO>();
        when(endpointUrlService.getChildrenByAddress(any(String.class))).thenReturn(childrenByAdressDTOList);

        MvcResult mvcResult = this.mockMvc.perform(get("/childAlert?address=AAAA")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(endpointUrlService, times(1)).getChildrenByAddress(any(String.class));
    }


    @Test
    public void getPhoneNumbersByFirestation() throws Exception {
        List<String> phoneList = new ArrayList<String>();
       PhoneAlertByStationNumberDTO phoneAlertByStationNumberDTOArrayList = new PhoneAlertByStationNumberDTO(phoneList);
        when(endpointUrlService.getPhoneNumbersByFirestation(any(int.class))).thenReturn(phoneAlertByStationNumberDTOArrayList);

        MvcResult mvcResult = this.mockMvc.perform(get("/phoneAlert?firestation=0")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(endpointUrlService, times(1)).getPhoneNumbersByFirestation(any(int.class));
    }

    @Test
    public void getPersonsByAddress() throws Exception {

        List<Person> listPersons = new ArrayList<Person>();
        List<MedicalRecord> listMedicalRecords = new ArrayList<MedicalRecord>();
        Firestation         firestations       = new Firestation();
        List<Long>          age                = null;
        ListPersonByAdressDTO listPersonByAdressDTO = new ListPersonByAdressDTO(listPersons, listMedicalRecords,
                firestations, age);
        when(endpointUrlService.getPersonsByAddress(any(String.class))).thenReturn(listPersonByAdressDTO);

        MvcResult mvcResult = this.mockMvc.perform(get("/fire?address=AAAA")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(endpointUrlService, times(1)).getPersonsByAddress(any(String.class));
    }

    @Test
    public void showPersonsAddressByFirestation() throws Exception {
        List<String> medications = new ArrayList<String>();
        List<String> allergies = new ArrayList<String>();
        PersonsAddressByFirestationDTO personsAddressByFirestationDTO = new PersonsAddressByFirestationDTO("lastName", "phone", 55L, medications,allergies);

        List<PersonsAddressByFirestationDTO> personsAddressByFirestationDTOList = new ArrayList<PersonsAddressByFirestationDTO>();
        personsAddressByFirestationDTOList.add(personsAddressByFirestationDTO);
        when(endpointUrlService.getPersonsAddressByFirestations(any(List.class))).thenReturn(personsAddressByFirestationDTOList);

        MvcResult mvcResult = this.mockMvc.perform(get("/flood/stations?stationList=0")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(endpointUrlService, times(1)).getPersonsAddressByFirestations(any(List.class));
    }

    @Test
    public void showPersonInfoByPerson() throws Exception {

        List<PersonInfoDTO> personInfoDTOList = new ArrayList<PersonInfoDTO>();
        when(endpointUrlService.getPersonInfoByPerson(any(String.class), any(String.class)))
                .thenReturn(personInfoDTOList);

        MvcResult mvcResult = this.mockMvc.perform(get("/personInfo?firstName=AAAA&lastName=BBBB")).andDo(print())
                                          .andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(endpointUrlService, times(1)).getPersonInfoByPerson(any(String.class), any(String.class));
    }

    @Test
    public void showMailsByCity() throws Exception {

        List<String> emails = new ArrayList<String>();
        EmailDTO emailDTO = new EmailDTO(emails);
        when(endpointUrlService.getMailsByCity(any(String.class))).thenReturn(emailDTO);

        MvcResult mvcResult = this.mockMvc.perform(get("/communityEmail?city=AAAA")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
        verify(endpointUrlService, times(1)).getMailsByCity(any(String.class));
    }




}
