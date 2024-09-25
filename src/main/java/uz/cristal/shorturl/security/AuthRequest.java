package uz.cristal.shorturl.security;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
