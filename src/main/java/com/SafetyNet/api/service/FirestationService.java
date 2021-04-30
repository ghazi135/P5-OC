package com.SafetyNet.api.service;

import com.SafetyNet.api.dao.FirestationDao;
import com.SafetyNet.api.model.Firestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirestationService {


    private final FirestationDao firestationDao;
    @Autowired
    public FirestationService(FirestationDao firestationDao) {this.firestationDao = firestationDao;}


    public List<Firestation> findAll() {


        return firestationDao.findAll();
    }

    public Firestation findById(String address) {

        return firestationDao.findById(address);
    }

    public List<Firestation> save(Firestation firestation) {
        return  firestationDao.save(firestation);
    }

    public Firestation update(String address, Firestation firestation) {
        return firestationDao.update(address, firestation);
    }

    public void deleteById(String address) {
        firestationDao.deleteById(address);
    }
}
