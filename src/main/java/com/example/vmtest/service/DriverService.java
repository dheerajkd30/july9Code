package com.example.vmtest.service;

import com.example.vmtest.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private IDriverRepository driverRepository;

    public int saveDriver(Driver driver) {
        driverRepository.save(driver);

        return driver.getId();
    }
}
