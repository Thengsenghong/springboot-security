package com.rean.controller;

import com.rean.AuthenticationRequest;
import com.rean.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    @PostMapping(value = "create")
    public ResponseEntity<Object> create(@RequestBody AuthenticationRequest authenticationRequest){
        userService.getUser(authenticationRequest);
        return new ResponseEntity<>(authenticationRequest, HttpStatus.CREATED);
    }
}
