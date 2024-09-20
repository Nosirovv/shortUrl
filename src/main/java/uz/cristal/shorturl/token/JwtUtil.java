package uz.cristal.shorturl.token;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Component
public class JwtUtil {


    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(UserDetails userDetails, List<String> roles) {
        return createToken(userDetails.getUsername(), roles);
    }

    private String createToken(String subject, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(subject);
        claims.put("roles", roles);
        return Jwts.builder().setClaims(claims)
                .setSubject(String.format("%s", subject))
                .setIssuedAt(new Date()).setExpiration(new Date(new Date()
                        .getTime() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS512, "asdasdassfsdfsdfasdsadadasdasdasdasdadasdssdfsfSDFSDFSDFSDFasdadadadad34werwerewrwSDFSDFSDFsDFSDFsdfsdfsd8463232324sdSADDASDASDASDDASDasd")
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey("asdasdassfsdfsdfasdsadadasdasdasdasdadasdssdfsfSDFSDFSDFSDFasdadadadad34werwerewrwSDFSDFSDFsDFSDFsdfsdfsd8463232324sdSADDASDASDASDDASDasd")
                .parseClaimsJws(token).getBody();
    }
}
