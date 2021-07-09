package com.example.vmtest.service;

import com.example.vmtest.model.Driver;
import org.springframework.data.repository.CrudRepository;

public interface IDriverRepository extends CrudRepository<Driver,Integer> {
}
