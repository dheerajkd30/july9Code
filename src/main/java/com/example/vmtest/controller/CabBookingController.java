package com.example.vmtest.controller;

import com.example.vmtest.model.Cab;
import com.example.vmtest.model.Driver;
import com.example.vmtest.model.User;
import com.example.vmtest.service.CabService;
import com.example.vmtest.service.DriverService;
import com.example.vmtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CabBookingController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private UserService userService;

    @Autowired
    private CabService cabService;


    @PostMapping(value = "/driver")
    public int registerDriver(@RequestBody Driver driver) {

        driverService.saveDriver(driver);
        return driver.getId();
    }

    @PostMapping(value = "/user")
    public int registerUser(@RequestBody User user) {

        userService.saveUser(user);
        return user.getId();
    }

    @PostMapping(value = "/cab")
    public int registerCab(@RequestBody Cab cab) {

        cabService.saveCab(cab);
        return cab.getId();
    }

    @GetMapping(value = "/cab/{location}")
    public List<Cab> bookCabs(@PathVariable("location") String userLocation) {

        return cabService.getNearByCabs(userLocation);

    }

}
