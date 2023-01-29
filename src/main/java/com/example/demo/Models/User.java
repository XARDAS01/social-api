package com.example.demo.Models;

import com.example.demo.Payloads.Requests.AuthRegistrationRequest;
import com.example.demo.Services.GeneratorService;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uid, firstName;
    private String login, passwordHASH;

    public User () { }

    public User(AuthRegistrationRequest authRegistrationRequest) {
        this.uid = GeneratorService.initUID();
        this.firstName = authRegistrationRequest.getFirstName();
        this.login = authRegistrationRequest.getLogin();
        this.passwordHASH = authRegistrationRequest.getPasswordHASH();
    }

    public Long getId() {
        return id;
    }

    public String getUid() {
        return uid;
    }

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
