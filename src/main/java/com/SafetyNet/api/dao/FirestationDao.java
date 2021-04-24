package com.SafetyNet.api.dao;

import com.SafetyNet.api.Model.Firestation;

import java.util.List;

public interface FirestationDao {

    public List<Firestation> findAll();

    public Firestation findById(String firestationAddress);

    public List<Firestation> findAddressByStation(int station);

    public List<Firestation> save(Firestation firestation);

    public Firestation update(String firestationAddress, Firestation firestation);

    public void deleteById(String firestationAddress);
}
