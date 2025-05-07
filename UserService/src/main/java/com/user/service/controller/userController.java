package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.model.userModel;
import com.user.service.service.userService;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService service;

    @PostMapping("/register")
    public ResponseEntity<userModel> registerUser(@RequestBody userModel user) {
        String result = service.register(user);
        if (result.equals("Registered successfully!")) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
        }
    }
    
    @PutMapping("/update-user")
    public ResponseEntity<String> updateUser(@RequestParam Long userid ,@RequestBody userModel user){
    	String result=service.updateProfile(userid, user);
    	if(result.equals("Profile updated successfully!")) {
    		return new ResponseEntity<>(result,HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<>(result,HttpStatus.CONFLICT);
    	}
    }
    
    @GetMapping("/get-allUser")
    public List<userModel> findAllUser(){
    	return service.userDetails();
    }
}
