package com.example.demo.Models;

import com.example.demo.Payloads.Requests.PasswordAddRequest;
import jakarta.persistence.*;

@Entity
@Table(name = "passwords")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorUID, name, url, login, password, description;

    public Password() { }

    public Password(PasswordAddRequest passwordAddRequest) {
        this.authorUID = passwordAddRequest.getAuthorUID();
        this.name = passwordAddRequest.getName();
        this.url = passwordAddRequest.getUrl();
        this.login = passwordAddRequest.getLogin();
        this.password = passwordAddRequest.getPassword();
        this.description = passwordAddRequest.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getAuthorUID() {
        return authorUID;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }
}
