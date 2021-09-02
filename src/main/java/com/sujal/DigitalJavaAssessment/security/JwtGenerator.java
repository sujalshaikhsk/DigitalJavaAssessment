package com.sujal.DigitalJavaAssessment.security;

import com.sujal.DigitalJavaAssessment.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    Logger logger = LoggerFactory.getLogger(JwtGenerator.class);

    @Value("${security.secret.value}")
    private String secret;

    public String generate(JwtUser jwtUser) {

        logger.info("SECRET2: "+secret);

        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUsername());
        claims.put("UserId", String.valueOf(jwtUser.getId()));
        claims.put("Role", jwtUser.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
