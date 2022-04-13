package com.mandiri.dto;

public class UserRegisterForm {

    private String fullName;
    private String userName;
    private String email;
    private String password;
    private String passwordConfirm;


    public UserRegisterForm() {
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }
}
