package com.versed.app.userservice.controller;

import com.versed.app.userservice.data.User;
import com.versed.app.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserServiceController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/all", produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
}
