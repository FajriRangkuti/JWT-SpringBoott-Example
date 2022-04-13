package com.mandiri.service;

import com.mandiri.dto.UserRegisterForm;
import com.mandiri.entity.UserApps;
import com.mandiri.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAppService {

    @Autowired
    UserAppRepository userAppRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserApps registerUser(UserApps userApps){
        userApps.passwordEncryption(passwordEncoder);
        return userAppRepository.save(userApps);
    }

    public List<UserApps> findAllUser(UserApps userApps){
        return userAppRepository.findAll();
    }


}
