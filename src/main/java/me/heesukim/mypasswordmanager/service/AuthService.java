package me.heesukim.mypasswordmanager.service;

import me.heesukim.mypasswordmanager.model.User;
import me.heesukim.mypasswordmanager.repository.UserRepository;
import me.heesukim.mypasswordmanager.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        userRepository.save(new User(username, encodedPassword));
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtService.generateToken(username);
    }
}
