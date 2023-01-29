package com.example.demo.Payloads.Requests;

public class PasswordAddRequest {
    private String authorUID, name, url, login, password, description;

    public PasswordAddRequest() { }

    public PasswordAddRequest(String authorUID, String name, String url, String login, String password, String description) {
        this.authorUID = authorUID;
        this.name = name;
        this.url = url;
        this.login = login;
        this.password = password;
        this.description = description;
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
