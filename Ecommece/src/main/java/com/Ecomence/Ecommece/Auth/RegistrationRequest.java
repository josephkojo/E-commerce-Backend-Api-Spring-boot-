package com.Ecomence.Ecommece.Auth;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
