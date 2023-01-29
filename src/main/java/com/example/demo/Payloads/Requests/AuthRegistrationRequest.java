package com.example.demo.Payloads.Requests;

public class AuthRegistrationRequest {
    private String firstName;
    private String login, passwordHASH;

    public String getFirstName() {
        return firstName;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHASH() {
        return passwordHASH;
    }
}
