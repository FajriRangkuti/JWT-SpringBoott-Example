package com.mandiri.dto;

import com.mandiri.entity.UserApps;
import com.mandiri.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {

    private UserApps userApps;
    private List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

    public CustomUserDetail(UserApps userApps, List<GrantedAuthority> grantedAuthorities) {
        this.userApps = userApps;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return userApps.getPassword();
    }

    @Override
    public String getUsername() {
        return userApps.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
