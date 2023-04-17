package com.rean.controller;

import com.rean.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/todos")
@RequiredArgsConstructor
public class TodoController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<Object> getTodos(){
        userService.saveUserRoles();
        return new ResponseEntity<>("Created user successfully", HttpStatus.OK);
    }
}
