package com.Ecomence.Ecommece.Auth;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private String token;




}
