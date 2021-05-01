package com.SafetyNet.api.serviceTest;

import com.SafetyNet.api.dao.FirestationDAO;
import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.service.FirestationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FirestationServiceTest {

    FirestationService firestationService;

    List<Firestation> firestationList;

    @Mock
    FirestationDAO firestationDAO;

    @BeforeEach
    void setup(){
        firestationService = new FirestationService(firestationDAO);
    }

    @Test
    public void findAll(){
        firestationList = new ArrayList<Firestation>();
        Firestation firestation = new Firestation();
        firestation.setStation(10);
        firestation.setAddress("15 rue colonel dumont ");
        firestationList.add(firestation);
        when(firestationDAO.findAll()).thenReturn(firestationList);
        assertThat(firestationService.findAll().toString(), containsString("15 rue colonel dumont "));

    }

    @Test
    public void findById(){
        Firestation firestation = new Firestation();
        firestation.setStation(10);
        firestation.setAddress("15 rue colonel dumont ");
        when(firestationDAO.findById("15 rue colonel dumont ")).thenReturn(firestation);
        assertThat(firestationService.findById("15 rue colonel dumont ").toString(), containsString("15 rue colonel dumont "));


    }

    @Test
    public void addFirestation(){
        firestationList = new ArrayList<Firestation>();
        Firestation firestation = new Firestation();
        firestation.setStation(10);
        firestation.setAddress("15 rue colonel dumont ");
        firestationList.add(firestation);
        when(firestationDAO.findAll()).thenReturn(firestationList);
        assertThat(firestationService.save(firestation).toString(), containsString("15 rue colonel dumont "));
    }

    @Test
    public void updateFirestation(){
        firestationList = new ArrayList<Firestation>();
        Firestation firestation = new Firestation();
        firestation.setStation(10);
        firestation.setAddress("15 rue colonel dumont ");
        firestationList.add(firestation);
        when(firestationDAO.update("15 rue colonel dumont ",firestation)).thenReturn(firestation);
        assertThat(firestationService.update("15 rue colonel dumont ",firestation).toString(), containsString("15 rue colonel dumont "));

    }

    @Test
    public void deleteFirestation(){
        Firestation firestation = new Firestation();
        firestation.setStation(10);
        firestation.setAddress("15 rue colonel dumont ");
        firestationDAO.save(firestation);
        firestationDAO.deleteById("15 rue colonel dumont ");
        assertThat(firestationService.findAll().toString(), containsString(""));
    }

}
