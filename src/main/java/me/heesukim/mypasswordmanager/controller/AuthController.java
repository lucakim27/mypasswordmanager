package me.heesukim.mypasswordmanager.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import me.heesukim.mypasswordmanager.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> body) {

        authService.register(
                body.get("username"),
                body.get("password")
        );

        return "registered";
    }

    @PostMapping("/login")
    public String login(
            @RequestBody Map<String, String> body,
            HttpServletResponse response) {

        String token = authService.login(
                body.get("username"),
                body.get("password")
        );

        Cookie cookie = new Cookie("jwt", token);

        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24);

        response.addCookie(cookie);

        return "login successful";

    }
}
