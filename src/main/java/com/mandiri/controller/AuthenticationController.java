package com.mandiri.controller;


import com.mandiri.dto.CustomUserDetail;
import com.mandiri.dto.LoginForm;
import com.mandiri.security.JwtTokenUtil;
import com.mandiri.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

//    @Autowired
//    AuthenticationManager authenticationManager;

    @Autowired
    DaoAuthenticationProvider daoAuthenticationProvider;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody LoginForm loginForm){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginForm.getName(),loginForm.getPassword());
        daoAuthenticationProvider.authenticate(authenticationToken);
        UserDetails userDetails = customUserDetailService.loadUserByUsername(loginForm.getName());
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String,Object> response = new HashMap<>();
        response.put("token",token);
        return response;
    }

}
