package com.SafetyNet.api.controller;


import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.service.EndpointUrlService;

import com.SafetyNet.api.service.object.EndpointsUrlsObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EndpointsUrlController {

    @Autowired
    EndpointUrlService endpointUrlService ;

    @GetMapping(value = "/communityEmail/{city}")
    public EndpointsUrlsObject showMailsByCity(@PathVariable String city) {
        List<String> email = new ArrayList<String>();
        for (Person person : endpointUrlService.showMailsByCity(city)){
            email.add(person.getEmail());
        }
        return new EndpointsUrlsObject(email);
    }
}
