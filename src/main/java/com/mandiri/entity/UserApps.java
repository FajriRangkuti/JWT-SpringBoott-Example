package com.mandiri.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mandiri.dto.UserRegisterForm;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_user")
public class UserApps {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    private String fullName;
    private String userName;
    private String email;

    @JsonIgnore
    private String password;

    public UserApps() {
    }

    public UserApps(UserRegisterForm userRegisterForm) {
        this.fullName = userRegisterForm.getFullName();
        this.userName = userRegisterForm.getUserName();
        this.email = userRegisterForm.getEmail();
        this.password = userRegisterForm.getPassword();
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void passwordEncryption(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.password);
    }
}
