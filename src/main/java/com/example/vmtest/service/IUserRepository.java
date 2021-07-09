package com.example.vmtest.service;

import com.example.vmtest.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User,Integer> {
}
