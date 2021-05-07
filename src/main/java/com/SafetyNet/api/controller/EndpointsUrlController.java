package com.SafetyNet.api.controller;


import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.service.EndpointUrlService;
import com.SafetyNet.api.service.object.ChildrenByAdressObject;
import com.SafetyNet.api.service.object.EndpointsUrlsObject;
import com.SafetyNet.api.service.object.ListPersonByAdressObject;
import com.SafetyNet.api.service.object.PhoneAlertByStationNumberObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class EndpointsUrlController {

    final EndpointUrlService endpointUrlService;

    @Autowired
    public EndpointsUrlController(EndpointUrlService endpointUrlService) {this.endpointUrlService = endpointUrlService;}


    @GetMapping(value = "/firestation{stationNumber}")
    public EndpointsUrlsObject getPersonsByFirestation(@PathVariable int stationNumber) throws ParseException {

        return endpointUrlService.getPersonsByFirestation(stationNumber);
    }


    @GetMapping(value = "/childAlert{address}")
    public ChildrenByAdressObject showChildrenByAddress(@PathVariable String address) throws ParseException {

        ChildrenByAdressObject childrenByAdressObject = endpointUrlService.showChildrenByAddress(address);
        long                   children               = ChildrenByAdressObject.getChildren();
        if (children == 0) {
            return null;
        } else {

            return childrenByAdressObject;
        }
    }


    @GetMapping(value = "/communityEmail/{city}")
    public EndpointsUrlsObject getMailsByCity(@PathVariable String city) {

        List<String> email = new ArrayList<String>();
        for (Person person : endpointUrlService.getMailsByCity(city)) {
            email.add(person.getEmail());
        }
        return new EndpointsUrlsObject(email);
    }

    @GetMapping(value = "/phoneAlert{stationNumber}")
    public PhoneAlertByStationNumberObject getPhoneNumbersByFirestation(@PathVariable int stationNumber) {

        return endpointUrlService.getPhoneNumbersByFirestation(stationNumber);
        }

    @GetMapping(value = "/fire{address}")
    public ListPersonByAdressObject getPersonsByAddress(@PathVariable String address) throws ParseException {

        return endpointUrlService.getPersonsByAddress(address);
    }

    }




