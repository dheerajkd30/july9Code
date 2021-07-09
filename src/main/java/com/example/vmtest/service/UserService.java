package com.example.vmtest.service;

import com.example.vmtest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public int saveUser(User user
    ) {
        userRepository.save(user);

        return user.getId();
    }
}
