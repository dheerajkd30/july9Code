package com.example.vmtest.service;

import com.example.vmtest.model.Cab;
import com.example.vmtest.model.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public interface ICabRepository extends CrudRepository<Cab, Integer> {

    default List<Cab> getNearByCab(List<Cab> allCabs, Location userlocation) {

        int userX = userlocation.getX();
        int userY = userlocation.getY();
        List<Cab> nearByCab = new ArrayList<>();

        allCabs.stream().forEach(cab -> {

            Location cabLocation = new Location();
            String cabLocString = cab.getLocation();
            String[] cabLocationArr = cabLocString.split(",");

            cabLocation.setX(Integer.parseInt(cabLocationArr[0]));
            cabLocation.setY(Integer.parseInt(cabLocationArr[1]));

            if (sqrt((userX - cabLocation.getX()) * 2 + (userY - cabLocation.getY()) * 2) < 500) {
                nearByCab.add(cab);
            }
        });
        return nearByCab;

    }
}
