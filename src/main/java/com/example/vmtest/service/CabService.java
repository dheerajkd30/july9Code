package com.example.vmtest.service;

import com.example.vmtest.model.Cab;
import com.example.vmtest.model.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CabService {

    @Autowired
    private ICabRepository cabRepository;

    public int saveCab(Cab cab) {
        cabRepository.save(cab);

        return cab.getId();
    }

    public List<Cab> getAllCabs() {

        List<Cab> allCabs = new ArrayList<>();
        cabRepository.findAll().forEach(allCabs::add);
        return allCabs;
    }

    public List<Cab> getNearByCabs(String location) {

        String[] locationArr = location.split(",");

        Location userLocation = new Location();
        userLocation.setX(Integer.parseInt(locationArr[0]));
        userLocation.setY(Integer.parseInt(locationArr[1]));

        List<Cab>  allCab  =getAllCabs();
        cabRepository.getNearByCab(allCab, userLocation);

        return allCab;
    }
}
