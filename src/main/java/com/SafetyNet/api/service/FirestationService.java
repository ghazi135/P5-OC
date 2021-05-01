package com.SafetyNet.api.service;

import com.SafetyNet.api.dao.FirestationDAO;
import com.SafetyNet.api.model.Firestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirestationService {

    @Autowired
    private FirestationDAO firestationDao;

    @Autowired
    public FirestationService(FirestationDAO firestationDAO) {
        this.firestationDao = firestationDAO;
    }

    public List<Firestation> findAll() {

        return firestationDao.findAll();
    }

    public Firestation findById(String address) {

        return firestationDao.findById(address);
    }

    public List<Firestation> save(Firestation firestation) {
        firestationDao.save(firestation);
        return  firestationDao.findAll();
    }

    public Firestation update(String address, Firestation firestation) {
        return firestationDao.update(address, firestation);
    }

    public void deleteById(String address) {
        firestationDao.deleteById(address);
    }
}
