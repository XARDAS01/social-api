package com.example.demo.Models;

import com.example.demo.Services.GeneratorService;
import jakarta.persistence.*;

@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uid, token;

    public Token() { }

    public Token(String uid) {
        this.uid = uid;
        this.token = GeneratorService.initToken();
    }

    public Long getId() {
        return id;
    }

    public String getUid() {
        return uid;
    }

    public String getToken() {
        return token;
    }
}
