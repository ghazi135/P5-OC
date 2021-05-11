package com.SafetyNet.api.dto;

import java.util.List;

public class PhoneAlertByStationNumberDTO {


    private final List<String> phonePersonList;


    public PhoneAlertByStationNumberDTO(List<String> phonePersonList) {

        this.phonePersonList = phonePersonList;
    }

    public List<String> getPhonePersonList() {

        return phonePersonList;
    }

}
