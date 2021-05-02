package com.SafetyNet.api.service;

import com.SafetyNet.api.dao.FirestationDAO;
import com.SafetyNet.api.dao.MedicalRecordDAO;
import com.SafetyNet.api.dao.PersonDAO;
import com.SafetyNet.api.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class EndpointUrlService {

    @Autowired
    private PersonDAO        personDAO;
//    @Autowired
//    private FirestationDAO   firestationDAO;
//    @Autowired
//    private MedicalRecordDAO medicalRecordDAO;

    public List<Person> showMailsByCity(String city) {



        return  personDAO.findEmailByCity(city);
    }
}
