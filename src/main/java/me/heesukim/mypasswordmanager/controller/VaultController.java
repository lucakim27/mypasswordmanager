package me.heesukim.mypasswordmanager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VaultController {
    @GetMapping("/vault")
    public String vault(Authentication authentication, Model model) {
        model.addAttribute("username", authentication.getName());
        return "vault";
    }
}
