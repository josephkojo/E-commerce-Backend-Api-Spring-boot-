package com.Ecomence.Ecommece.Auth;

import lombok.Data;

@Data
public class AuthenticateRequest {
    private String email;
    private String password;

}
