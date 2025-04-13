package com.railApplication.controller;

import com.railApplication.Entity.User;
import com.railApplication.Repo.UserDetailsRepo;
import com.railApplication.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.railApplication.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;

@RequestMapping("/authenticate")
@RestController
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtils;

    @Autowired
    private UserDetailsRepo userRepo;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/user/signin/{username}/{pwd}")
    public ResponseEntity<String> authenticateUser(@PathVariable String username, @PathVariable String pwd){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        pwd
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return new ResponseEntity<String>(jwtUtils.generateToken(userDetails.getUsername()),HttpStatus.OK);
    }



    @PostMapping("/user/signup/{username}/{pwd}")
    public String registerUser(@PathVariable String username, @PathVariable String pwd) {

        // Create new user's account
        User newUser = new User(username,
                encoder.encode(pwd)
        );
        userRepo.save(newUser);
        return "User registered successfully!";
    }
}
