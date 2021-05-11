package com.SafetyNet.api.controller;


import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.service.EndpointUrlService;
import com.SafetyNet.api.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    public PersonByFirestationDTO getPersonsByFirestation(@PathVariable int stationNumber) throws ParseException {

        return endpointUrlService.getPersonsByFirestation(stationNumber);
    }


    @GetMapping(value = "/childAlert{address}")
    public List<ChildrenByAdressDTO> showChildrenByAddress(@PathVariable String address) throws ParseException {

       return endpointUrlService.showChildrenByAddress(address);
    }


    @GetMapping(value = "/communityEmail/{city}")
    public EmailDTO getMailsByCity(@PathVariable String city) {

        List<String> email = new ArrayList<>();
        for (Person person : endpointUrlService.getMailsByCity(city)) {
            email.add(person.getEmail());
        }
        return new EmailDTO(email);
    }

    @GetMapping(value = "/phoneAlert{stationNumber}")
    public PhoneAlertByStationNumberDTO getPhoneNumbersByFirestation(@PathVariable int stationNumber) {

        return endpointUrlService.getPhoneNumbersByFirestation(stationNumber);
    }

    @GetMapping(value = "/fire{address}")
    public ListPersonByAdressDTO getPersonsByAddress(@PathVariable String address) throws ParseException {

        return endpointUrlService.getPersonsByAddress(address);
    }

    @GetMapping(value = "/flood/stations{stations}")
    public List<PersonsAddressByFirestationDTO>  showPersonsAddressByFirestation(@PathVariable int stations) throws ParseException {

        return endpointUrlService.showPersonsAddressByFirestation(stations);
    }


    @GetMapping(value = "/personInfo{firstName}{lastName}")
    public List<PersonInfoDTO> showPersonInfoByPerson(@RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName) throws ParseException {

        return endpointUrlService.showPersonInfoByPerson(firstName, lastName);
    }




}




