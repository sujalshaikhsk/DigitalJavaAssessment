package com.sujal.DigitalJavaAssessment.security;

import com.sujal.DigitalJavaAssessment.exception.JwtSecurityException;
import com.sujal.DigitalJavaAssessment.model.JwtAuthenticationToken;
import com.sujal.DigitalJavaAssessment.util.StringConstant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationTokenFilter() {
        super("customers/getAccountDetails/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        String header=httpServletRequest.getHeader("Authorization");
        if(Objects.isNull(header)|| !header.startsWith("Token-")){
            throw new JwtSecurityException(StringConstant.JWT_MISSING);
        }

        String authenticationToken=header.substring(6);
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
