package com.SafetyNet.api.controller;

import com.SafetyNet.api.model.MedicalRecord;
import com.SafetyNet.api.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping(value = "/medicalRecord")
    public List<MedicalRecord> showAllMedicalRecords() {

        return medicalRecordService.findAll();
    }

    @GetMapping(value = "/medicalRecord/{firstNameAndlastName}")
    public MedicalRecord showMedicalRecordById(@PathVariable String firstNameAndlastName)  {

        return medicalRecordService.findById(firstNameAndlastName);
    }

    @PostMapping(value = "/medicalRecord")
    public List<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return  medicalRecordService.save(medicalRecord);
    }

    @PutMapping(value = "/medicalRecord/{firstNameAndlastName}")
    public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord,
            @PathVariable String firstNameAndlastName) throws ParseException {
        return medicalRecordService.update(firstNameAndlastName, medicalRecord);
    }

    @DeleteMapping(value = "/medicalRecord/{firstNameAndlastName}")
    public void deleteMedicalRecord(@PathVariable String firstNameAndlastName) {
        medicalRecordService.deleteById(firstNameAndlastName);
    }
}
