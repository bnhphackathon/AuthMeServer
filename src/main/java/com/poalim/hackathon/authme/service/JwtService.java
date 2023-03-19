package com.poalim.hackathon.authme.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
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
                .claim("pin", String.format("%06d", (int) (Math.random() * 1000000))) // 6 digit pin code
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
        String pin = claims.get("pin", String.class);
        return pin;
    }


    public String newJwt() {
        setPublicKey(secretKeyBase64);
        setSecretKey(publicKeyBase64);

        String jwtGen = generateJwt();
        String jwtDec = decryptJwt(jwtGen);
        return jwtGen;

    }
}
