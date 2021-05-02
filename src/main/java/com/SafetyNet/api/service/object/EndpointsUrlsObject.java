package com.SafetyNet.api.service.object;


import java.util.List;

public class EndpointsUrlsObject {

    private final List<String> email;

    public EndpointsUrlsObject(List<String> email) {

        this.email = email;
    }

    public List<String> getEmail() {

        return email;
    }

}
