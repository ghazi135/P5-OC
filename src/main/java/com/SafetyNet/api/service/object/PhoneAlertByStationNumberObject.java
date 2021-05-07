package com.SafetyNet.api.service.object;

import java.util.List;

public class PhoneAlertByStationNumberObject {


    private final List<String> phonePersonList;


    public PhoneAlertByStationNumberObject(List<String> phonePersonList) {

        this.phonePersonList = phonePersonList;
    }

    public List<String> getPhonePersonList() {

        return phonePersonList;
    }

}
