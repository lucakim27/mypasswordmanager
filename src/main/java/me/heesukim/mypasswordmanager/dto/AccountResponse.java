package me.heesukim.mypasswordmanager.dto;

public class AccountResponse {
    private Long id;
    private String website;
    private String username;
    private String password; // decrypted

    public AccountResponse(Long id, String website, String username, String password) {
        this.id = id;
        this.website = website;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}