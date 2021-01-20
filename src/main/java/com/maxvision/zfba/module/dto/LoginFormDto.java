package com.maxvision.zfba.module.dto;

/**
 * @author minte
 * @date 2021/1/14 21:05
 */
public class LoginFormDto {
    private String username;
    private String password;
    private String rememberMe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }
}
