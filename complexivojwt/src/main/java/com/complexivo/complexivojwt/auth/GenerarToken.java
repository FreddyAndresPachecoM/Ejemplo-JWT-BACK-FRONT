package com.complexivo.complexivojwt.auth;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GenerarToken {

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";
    private static final String SECRET = "clavesecreta";

    public static String getJwtToken(String username){
     
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        
        String token = Jwts
        .builder()
        .setId("complexivoToken")
        .setSubject(username)
        .claim("authorities", grantedAuthorities.stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList()))
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis()+600000))
        .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
        .compact();

        return PREFIX+token;
        
    }
    
}