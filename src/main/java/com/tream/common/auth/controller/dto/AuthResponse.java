package com.tream.common.auth.controller.dto;

import java.io.Serializable;

public class AuthResponse implements Serializable{

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    private final String randomKey;

    public AuthResponse(String token, String randomKey) {
        this.token = token;
        this.randomKey = randomKey;
    }

    public String getToken() {
        return token;
    }

    public String getRandomKey() {
        return randomKey;
    }
}
