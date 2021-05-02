package com.SafetyNet.api.controller;


import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.service.EndpointUrlService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EndpointsUrlController {

    @Autowired
    EndpointUrlService endpointUrlService ;

    @GetMapping(value = "/communityEmail/{city}")
    public List<String> showMailsByCity(@PathVariable String city) {
        List<String> email = new ArrayList<String>();
        for (Person person : endpointUrlService.showMailsByCity(city)){
            email.add(person.getEmail());
        }
        return email;
    }
}
