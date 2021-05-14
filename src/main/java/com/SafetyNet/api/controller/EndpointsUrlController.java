package com.SafetyNet.api.controller;


import com.SafetyNet.api.dto.*;
import com.SafetyNet.api.service.EndpointUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;


@RestController
public class EndpointsUrlController {

    final EndpointUrlService endpointUrlService;

    @Autowired
    public EndpointsUrlController(EndpointUrlService endpointUrlService) {this.endpointUrlService = endpointUrlService;}


    @GetMapping(value = "/firestation{station_Number}")
    public PersonByFirestationDTO getPersonsByFirestation(@RequestParam(value = "stationNumber") int station_Number) throws ParseException {

        return endpointUrlService.getPersonsByFirestation(station_Number);
    }


    @GetMapping(value = "/childAlert{address}")
    public List<ChildrenByAdressDTO> getChildrenByAddress(@RequestParam(value = "address") String address) throws ParseException {

        return endpointUrlService.getChildrenByAddress(address);
    }


    @GetMapping(value = "/phoneAlert{stationNumber}")
    public PhoneAlertByStationNumberDTO getPhoneNumbersByFirestation(@RequestParam(value = "firestation") int stationNumber) {

        return endpointUrlService.getPhoneNumbersByFirestation(stationNumber);
    }

    @GetMapping(value = "/fire{address}")
    public List<PersonByAdressDTO> getPersonsByAddress(@RequestParam(value = "address") String address) throws ParseException {

        return endpointUrlService.getPersonsByAddress(address);
    }

    @GetMapping(value = "/flood/stations{stations}")
    public List<PersonsAddressByFirestationDTO> getPersonsAddressByFirestation(@RequestParam(value = "stationList") List<Integer> stations) throws ParseException {

        return endpointUrlService.getPersonsAddressByFirestations(stations);
    }


    @GetMapping(value = "/personInfo{firstName}{lastName}")
    public List<PersonInfoDTO> getPersonInfoByPerson(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) throws ParseException {

        return endpointUrlService.getPersonInfoByPerson(firstName, lastName);
    }

    @GetMapping(value = "/communityEmail{city}")
    public EmailDTO getMailsByCity(@RequestParam(value = "city") String city) {

        return endpointUrlService.getMailsByCity(city);
    }


}




