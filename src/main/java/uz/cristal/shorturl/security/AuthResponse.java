package uz.cristal.shorturl.security;

public class AuthResponse {
    private String jwt;

    public AuthResponse(String jwt){
        this.jwt = jwt;
    }
    public String getJwt(){
        return jwt;
    }
}
