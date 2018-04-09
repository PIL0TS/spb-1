package com.tream.common.auth.controller.dto;

import com.tream.common.auth.validator.dto.Credence;


public class AuthRequest implements Credence{

    private String loginId;
    private String passWord;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String getCredenceName() {
        return this.loginId;
    }

    @Override
    public String getCredenceCode() {
        return this.passWord;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "loginId='" + loginId + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
