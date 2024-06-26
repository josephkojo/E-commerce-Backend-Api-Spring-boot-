package com.Ecomence.Ecommece.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegistrationRequest registrationRequest){
        AuthenticationResponse authenticationResponse = authenticationService.registerUser(registrationRequest);
        return new ResponseEntity<>(authenticationResponse, HttpStatus.CREATED);


    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody AuthenticateRequest authenticateRequest){
        AuthenticationResponse authenticationResponse = this.authenticationService.loginUser(authenticateRequest);
        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }
}
