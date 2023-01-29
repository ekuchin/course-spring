package org.example.controller;

import org.example.model.Token;
import org.example.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {

    @Autowired private TokenService tokenService;


    @PostMapping("/auth")
    public ResponseEntity<Token> token(Authentication authentication, Principal principal){
        Token token = new Token(tokenService.generateToken(authentication));
        return ResponseEntity.ok(token);
    }

}
