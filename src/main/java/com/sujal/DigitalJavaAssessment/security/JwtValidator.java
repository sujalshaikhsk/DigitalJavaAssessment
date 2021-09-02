package com.sujal.DigitalJavaAssessment.security;

import com.sujal.DigitalJavaAssessment.model.JwtUser;
import com.sujal.DigitalJavaAssessment.util.Validator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator implements Validator {

    Logger logger = LoggerFactory.getLogger(JwtValidator.class);

    @Value("${security.secret.value}")
    private String secret;

    @Override
    public Object validate(Object token) {

        JwtUser jwtUser= null;

        logger.info("SECRET1: "+secret);
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws((String)token)
                    .getBody();

            jwtUser = new JwtUser();
            jwtUser.setUsername(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        }catch (Exception e){
            //looger
           //e.getMessage();
        }

        return jwtUser;
    }
}
