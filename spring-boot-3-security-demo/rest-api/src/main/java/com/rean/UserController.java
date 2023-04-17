package com.rean;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @GetMapping()
    public ResponseEntity<Object> getUsers(){
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(new User(
                        "Rean",
                        "Code",
                        "reanCode@gmail.com"
                ));
    }
}
