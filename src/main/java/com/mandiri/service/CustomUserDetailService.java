package com.mandiri.service;

import com.mandiri.dto.CustomUserDetail;
import com.mandiri.entity.UserApps;
import com.mandiri.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserAppRepository userAppRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!userAppRepository.findUserAppsByUserName(username).isPresent()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid Username or Password");
        }
        UserApps userApps = userAppRepository.findUserAppsByUserName(username).get();

        List<GrantedAuthority> authorities = new ArrayList<>();
        return new CustomUserDetail(userApps,authorities);
    }
}
