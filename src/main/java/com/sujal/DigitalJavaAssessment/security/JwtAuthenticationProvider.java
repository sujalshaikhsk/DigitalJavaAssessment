package com.sujal.DigitalJavaAssessment.security;

import com.sujal.DigitalJavaAssessment.exception.JwtSecurityException;
import com.sujal.DigitalJavaAssessment.model.JwtAuthenticationToken;
import com.sujal.DigitalJavaAssessment.model.JwtUser;
import com.sujal.DigitalJavaAssessment.model.JwtUserDetials;
import com.sujal.DigitalJavaAssessment.util.StringConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidator jwtValidator;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken= (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token= jwtAuthenticationToken.getToken();
        JwtUser jwtUser= (JwtUser) jwtValidator.validate(token);
        if(Objects.isNull(jwtUser)){
            throw new JwtSecurityException(StringConstant.JWT_INCORRECT);
        }

        List<GrantedAuthority> grantedAuthorityList= AuthorityUtils
                .commaSeparatedStringToAuthorityList(jwtUser.getRole());

        return new JwtUserDetials(jwtUser.getId(), jwtUser.getUsername(),
                token, grantedAuthorityList);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return JwtAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
