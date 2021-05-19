package com.SafetyNet.api.controller;

import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.service.FirestationService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class FirestationController {


    @Autowired
    private FirestationService firestationService;


    @GetMapping(value = "/firestations")
    public List<Firestation> showAllFirestations() {

        log.info("/firestations");

        return firestationService.findAll();
    }

    @GetMapping(value = "/firestation/{address}")
    public Firestation showFirestationById(@PathVariable String address) {

        log.info("/firestation/{address}");

        return firestationService.findById(address);
    }

    @PostMapping(value = "/firestation")
    public List<Firestation> addFirestation(@RequestBody Firestation firestation) {

        log.info("post: /firestation");
        return firestationService.save(firestation);
    }

    @PutMapping(value = "/firestation/{address}")
    public Firestation updateFirestation(@RequestBody Firestation firestation, @PathVariable String address) {

        log.info("put: /firestation");
        return firestationService.update(address, firestation);
    }

    @DeleteMapping(value = "/firestation/{address}")
    public void deleteFirestation(@PathVariable String address) {

        log.info("Delete: /firestation");
        firestationService.deleteById(address);
    }
}
