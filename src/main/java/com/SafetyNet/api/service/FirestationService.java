package com.SafetyNet.api.service;

import com.SafetyNet.api.dao.FirestationDAO;
import com.SafetyNet.api.model.Firestation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class FirestationService {


    @Autowired
    private FirestationDAO firestationDao;

    @Autowired
    public FirestationService(FirestationDAO firestationDAO) {

        this.firestationDao = firestationDAO;
    }

    public List<Firestation> findAll() {

        log.info("find all firestations");

        return firestationDao.findAll();
    }

    public Firestation findById(String address) {

        log.info("find firestation by address");
        return firestationDao.findById(address);
    }

    public List<Firestation> save(Firestation firestation) {

        log.info("save firesation");
        firestationDao.save(firestation);
        return firestationDao.findAll();
    }

    public Firestation update(String address, Firestation firestation) {

        log.info("update firesation by address");
        return firestationDao.update(address, firestation);
    }

    public List<Firestation> deleteById(String address) {

        log.info("delete firesation by address");
        firestationDao.deleteById(address);
        return firestationDao.findAll();
    }
}
