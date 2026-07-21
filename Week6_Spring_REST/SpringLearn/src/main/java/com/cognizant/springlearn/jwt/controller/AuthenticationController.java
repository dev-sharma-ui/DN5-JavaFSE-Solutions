package com.cognizant.springlearn.jwt.controller;

import org.springframework.web.bind.annotation.*;

import com.cognizant.springlearn.jwt.AuthenticationRequest;
import com.cognizant.springlearn.jwt.AuthenticationResponse;
import com.cognizant.springlearn.jwt.util.JwtUtil;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @PostMapping
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest request) {

        String token =
                JwtUtil.generateToken(request.getUsername());

        return new AuthenticationResponse(token);
    }
}