package me.heesukim.mypasswordmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String website;

    private String accountUsername;

    private String encryptedPassword;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Account() {
    }

    public Account(
            String website,
            String accountUsername,
            String encryptedPassword,
            User user) {

        this.website = website;
        this.accountUsername = accountUsername;
        this.encryptedPassword = encryptedPassword;
        this.user = user;
    }

    public String getUsername() { return accountUsername; }
    public void setUsername(String username) { this.accountUsername = username; }

    public String getPassword() { return encryptedPassword; }
    public void setPassword(String password) { this.encryptedPassword = password; }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Long getId() {
        return id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
