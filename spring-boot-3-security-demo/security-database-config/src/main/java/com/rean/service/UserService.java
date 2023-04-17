package com.rean.service;

import com.rean.AuthenticationRequest;
import com.rean.model.Role;
import com.rean.model.User;
import com.rean.repository.RoleRepository;
import com.rean.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;
    public void saveUserRoles(){
        Role userRole = Role
                .builder()
                .name("ROLE_USER")
                .build();
        Role adminRole = Role
                .builder()
                .name("ROLE_ADMIN")
                .build();
        roleRepository.save(userRole);
        roleRepository.save(adminRole);

        Set<Role> roles = roleRepository.findAllByName("ROLE_ADMIN");
        User user = User.builder()
                .fullname("Rean Code")
                .username("reancode")
                .password(passwordEncoder.encode("Caesar@123"))
                .roles(roles)
                .build();

        userRepository.save(user);
    }

    public void getUser(AuthenticationRequest authenticationRequest){
        String url= "http://localhost:8080/api/v1/products";
        var usernamePassword =   authenticationRequest.username()+":"+authenticationRequest.password();
        byte[] plainCredentialBytes = usernamePassword.getBytes();
        byte[] base64CredentialBytes = Base64.getEncoder().encode(plainCredentialBytes);
        String base64Credential = new String(base64CredentialBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic" + base64Credential);
        HttpEntity<Objects> objectHttpEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, objectHttpEntity, String.class);
        log.info("Login response {}", response.getBody());
    }
}
