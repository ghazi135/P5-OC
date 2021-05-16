package com.SafetyNet.api.service;

import com.SafetyNet.api.dao.MedicalRecordDAO;
import com.SafetyNet.api.model.MedicalRecord;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Log4j2
@Service
public class MedicalRecordService {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(MedicalRecordService.class);

    @Autowired
    private MedicalRecordDAO medicalRecordDAO;

    @Autowired
    public MedicalRecordService(MedicalRecordDAO medicalRecordDAO) {

        this.medicalRecordDAO = medicalRecordDAO;

    }

    public List<MedicalRecord> findAll() {

        log.info("find  all medicalRecords");
        return medicalRecordDAO.findAll();
    }

    public MedicalRecord findById(String address) {

        log.info("find medicalRecord by address");
        return medicalRecordDAO.findById(address);
    }

    public List<MedicalRecord> save(MedicalRecord medicalRecord) {

        log.info("save medicalRecord ");

        return medicalRecordDAO.save(medicalRecord);
    }

    public MedicalRecord update(String address, MedicalRecord medicalRecord) throws ParseException {

        log.info("update medicalRecord");

        return medicalRecordDAO.update(address, medicalRecord);
    }

    public void deleteById(String address) {

        log.info("delete medicalRecord by adsress");

        medicalRecordDAO.deleteById(address);
    }

}
