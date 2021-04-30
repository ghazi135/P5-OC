package com.SafetyNet.api.dao;

import com.SafetyNet.api.json.DataReaderService;
import com.SafetyNet.api.model.Firestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FirestationDaoImpl  implements FirestationDao{

    private final List<Firestation> firestations;

    @Autowired
    public FirestationDaoImpl(List<Firestation> firestion) throws Exception {
        super();
        firestion = new DataReaderService().getData().getFirestations();
        this.firestations = firestion;
    }

    @Override
    public List<Firestation> findAll() {
        return firestations;
    }

    @Override
    public Firestation findById(String firestationAddress) {
        for (Firestation address : firestations) {
            if ((address.getAddress()).equals(firestationAddress)) {
                return address;
            }
        }
        return null;
    }

    @Override
    public List<Firestation> findAddressByStation(int station) {
        List<Firestation> listFirestation = new ArrayList<Firestation>();
        for (Firestation firestation : firestations) {
            if (firestation.getStation() == station) {
                listFirestation.add(firestation);
            }
        }
        return listFirestation;
    }

    @Override
    public List<Firestation> save(Firestation firestation) {
        List<Firestation> saveFirestation = firestations;
        saveFirestation.add(firestation);
        return saveFirestation;
    }

    @Override
    public Firestation update(String firestationAddress, Firestation firestation) {
        for (Firestation updateFirestation : firestations) {
            if ((updateFirestation.getAddress()).equals(firestationAddress)) {
                updateFirestation.setStation(firestation.getStation());
                return updateFirestation;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String firestationAddress) {
        List<Firestation> deleteFirestation = firestations;
        deleteFirestation.removeIf(firestation -> firestation.getAddress().equals(firestationAddress));
    }

}
