package com.mandiri.security;
import com.mandiri.service.CustomUserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    @Autowired
    CustomUserDetailService customUserDetailService;

    private String secret = "aklndlanlskdnalsfnlnaalknskdlnalskdnklasdlkmaeklmkamkamsdnakjsndjkasdjkasdamsdnalksdlnaslkdnalknsdlansdnalsdnklasndklanflnaldnf";

    public String generateToken(UserDetails userDetails){

        Map<String,Object> claims = new HashMap<>();
        claims.put("roles",userDetails.getUsername());//<---- this set role;

        String token = Jwts.builder()
                .setClaims(claims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+(5*60*1000)))
                .signWith(SignatureAlgorithm.HS256, secret).compact();

        return token;

    }

    public UserDetails parseToken(String token){
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token);

        String userName = claimsJws.getBody().getSubject();

        return customUserDetailService.loadUserByUsername(userName);
    }

}
