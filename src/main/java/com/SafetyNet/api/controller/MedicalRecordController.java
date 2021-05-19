package com.SafetyNet.api.controller;

import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.service.MedicalRecordService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Log4j2
@RestController
public class MedicalRecordController {


    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping(value = "/medicalRecord")
    public List<MedicalRecord> showAllMedicalRecords() {

        log.info("post: /medicalRecord");
        return medicalRecordService.findAll();
    }

    @GetMapping(value = "/medicalRecord/{firstNameAndlastName}")
    public MedicalRecord showMedicalRecordById(@PathVariable String firstNameAndlastName) {

        log.info("GET: /medicalRecord/{firstNameAndlastName}");
        return medicalRecordService.findById(firstNameAndlastName);
    }

    @PostMapping(value = "/medicalRecord")
    public List<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {

        log.info("post: /medicalRecord");
        return medicalRecordService.save(medicalRecord);
    }

    @PutMapping(value = "/medicalRecord/{firstNameAndlastName}")
    public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord, @PathVariable String firstNameAndlastName) throws ParseException {

        log.info("put: /medicalRecord/{firstNameAndlastName}");
        return medicalRecordService.update(firstNameAndlastName, medicalRecord);
    }

    @DeleteMapping(value = "/medicalRecord/{firstNameAndlastName}")
    public void deleteMedicalRecord(@PathVariable String firstNameAndlastName) {

        log.info("Delete: /medicalRecord/{firstNameAndlastName}");
        medicalRecordService.deleteById(firstNameAndlastName);
    }
}
