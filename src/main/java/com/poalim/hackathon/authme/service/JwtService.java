package com.poalim.hackathon.authme.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;

@Service
public class JwtService {

    String secretKeyBase64 = "i24CQ2Dtl1ViRMYa2ZG7VlJiLdMW7m3wq3uWi7VfY1E";
    String publicKeyBase64 = "i24CQ2Dtl1ViRMYa2ZG7VlJiLdMW7m3wq3uWi7VfY1E";

    private  Key secretKey;
    private  Key publicKey;




    public void setSecretKey(String base64Key) {
//        if(Objects.isNull())   //todo
        byte[] keyBytes = Base64.getDecoder().decode(base64Key);
        secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public void setPublicKey(String base64Key) {
        byte[] keyBytes = Base64.getDecoder().decode(base64Key);
        publicKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateJwt() {
        if (secretKey == null) {
            throw new IllegalStateException("Secret key has not been set");
        }

        String jwt = Jwts.builder()
                .claim("otp", String.format("%06d", (int) (Math.random() * 1000000))) // 6 digit otp code
                .signWith(secretKey)
                .compact();
        return jwt;
    }

    public  String decryptJwt(String jwt) {
        if (publicKey == null) {
            throw new IllegalStateException("Public key has not been set");
        }

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        String otp = claims.get("otp", String.class);
        return otp;
    }

    @PostConstruct
    public void init() {
        setPublicKey(secretKeyBase64);
        setSecretKey(publicKeyBase64);
    }
    public String getNewJwt() {
        String jwtGen = generateJwt();
        String jwtDec = decryptJwt(jwtGen);
        return jwtGen;

    }
}
