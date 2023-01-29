package ru.projectosnova.springlearnsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.projectosnova.springlearnsecurity.jwt.JwtRequest;
import ru.projectosnova.springlearnsecurity.jwt.JwtToken;
import ru.projectosnova.springlearnsecurity.jwt.JwtResponse;
import ru.projectosnova.springlearnsecurity.service.JwtUserDetailsService;

@RestController
@CrossOrigin(origins = "*")
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping(value = "/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authRequest) throws Exception {
        try {
            authenticationManager
           .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (DisabledException e) {throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {throw new Exception("INVALID_CREDENTIALS", e);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtToken.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

}
