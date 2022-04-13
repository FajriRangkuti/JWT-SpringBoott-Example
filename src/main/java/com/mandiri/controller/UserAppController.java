package com.mandiri.controller;
import com.mandiri.dto.Message;
import com.mandiri.dto.UserRegisterForm;
import com.mandiri.entity.UserApps;
import com.mandiri.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserAppController {

    @Autowired
    UserAppService userAppService;

    @PostMapping("/user")
    public UserApps registerUser(@RequestBody UserRegisterForm userRegisterForm){
        UserApps userApps = new UserApps(userRegisterForm);
        return userAppService.registerUser(userApps);
    }

    @GetMapping("/users")
    public List<UserApps> getAllUser(UserApps userApps){
        return userAppService.findAllUser(userApps);
    }

    @PreAuthorize("hasAnyAuthority('dimas')")
    @GetMapping("/coba")
    public Message coba(){
        return new Message("Halo,Ini API lain nya","SUCCESS");
    }

}
