package com.rean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class CustomSecurityConfig {

    @Bean
    public UserDetailsService users(){
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$12$JPBUBF7AMAtFpEHRijilc.nTj5npytj2Ib/EcTlsxKiqlEIMrMnkG")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$12$JPBUBF7AMAtFpEHRijilc.nTj5npytj2Ib/EcTlsxKiqlEIMrMnkG")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

//    @Bean
//    public UserDetailsService users(){
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        UserDetails user = userBuilder
//                .username("user")
//                .password("user")
//                .roles("USER")
//                .build();
//        UserDetails admin = userBuilder
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}
