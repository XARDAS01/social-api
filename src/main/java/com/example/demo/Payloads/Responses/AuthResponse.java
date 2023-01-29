package com.example.demo.Payloads.Responses;

import com.example.demo.Models.Token;
import com.example.demo.Models.User;

public class AuthResponse {
    private String firstName;
    private String login, token;

    public AuthResponse(User user, Token token) {
        this.firstName = user.getFirstName();
        this.login = user.getLogin();
        this.token = token.getToken();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLogin() {
        return login;
    }

    public String getToken() {
        return token;
    }
}
