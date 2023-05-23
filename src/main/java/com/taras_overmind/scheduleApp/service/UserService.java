package com.taras_overmind.scheduleApp.service;


import com.taras_overmind.scheduleApp.model.User;
import com.taras_overmind.scheduleApp.model.UserRole;
import com.taras_overmind.scheduleApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public String registerNewAccount(User user) {
        if (userRepo.findByUsername(user.getUsername()) != null){
            return "Користувач з логіном " + user.getUsername() + " вже існує :(";
        }

        if (user.getPassword().length() < 6){
            return "Password must contain more than 6 characters";
        }

        User userEntity = new User();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setEmail(user.getEmail());
        userEntity.setRole(UserRole.USER);
        userRepo.save(userEntity);
        return null;
    }
}
