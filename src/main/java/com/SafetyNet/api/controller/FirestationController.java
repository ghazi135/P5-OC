package com.SafetyNet.api.controller;

import com.SafetyNet.api.model.Firestation;
import com.SafetyNet.api.service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirestationController {


    @Autowired
    private FirestationService firestationService;


    @GetMapping(value = "/firestation")
    public List<Firestation> showAllFirestations() {

        return firestationService.findAll();
    }

    @GetMapping(value = "/firestation/{address}")
    public Firestation showFirestationById(@PathVariable String address) {

        return firestationService.findById(address);
    }

    @PostMapping(value = "/firestation")
    public List<Firestation> addFirestation(@RequestBody Firestation firestation) {

        return firestationService.save(firestation);
    }

    @PutMapping(value = "/firestation/{address}")
    public Firestation updateFirestation(@RequestBody Firestation firestation, @PathVariable String address) {

        return firestationService.update(address, firestation);
    }

    @DeleteMapping(value = "/firestation/{address}")
    public void deleteFirestation(@PathVariable String address) {

        firestationService.deleteById(address);
    }
}
