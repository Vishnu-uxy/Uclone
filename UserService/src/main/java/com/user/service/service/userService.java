package com.user.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.Repo.userRepo;
import com.user.service.model.userModel;

@Service
public class userService {

    @Autowired
    private userRepo repo;

    public String register(userModel user) {
        if (user.getUserId() != null) {
            return "user already exist";
        }
        repo.save(user); // userId will be auto-generated
        return "Registered successfully!";
    }


    public String updateProfile(Long userId, userModel updatedUser) {
        Optional<userModel> existingUser = repo.findById(userId);
        if (existingUser.isPresent()) {
            userModel user = existingUser.get();
            
            // Update fields based on userModel
            user.setUsername(updatedUser.getUsername());
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setRole(updatedUser.getRole());
            user.setPassword(updatedUser.getPassword());
            
            repo.save(user);
            return "Profile updated successfully!";
        }
        return "User not found!";
    }
}
