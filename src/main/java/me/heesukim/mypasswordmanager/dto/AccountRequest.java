package me.heesukim.mypasswordmanager.dto;

public class AccountRequest {

    private String website;
    private String username;
    private String password;

    public String getWebsite() {
        return this.website;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}