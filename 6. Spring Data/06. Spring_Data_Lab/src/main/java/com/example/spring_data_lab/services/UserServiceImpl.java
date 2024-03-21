package com.example.spring_data_lab.services;

import com.example.spring_data_lab.models.User;
import com.example.spring_data_lab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        User found = this.userRepository.findByUsername(user.getUsername());
        if (found == null) {
            this.userRepository.save(user);
        }
    }
}
