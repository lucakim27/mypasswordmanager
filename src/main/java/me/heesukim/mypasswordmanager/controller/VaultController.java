package me.heesukim.mypasswordmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VaultController {
    @GetMapping("/vault")
    public String vault() {
        return "vault";
    }
}
