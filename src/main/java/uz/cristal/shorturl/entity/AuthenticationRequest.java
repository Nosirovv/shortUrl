package uz.cristal.shorturl.entity;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;
    private String password;
}

