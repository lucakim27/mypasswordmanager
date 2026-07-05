package me.heesukim.mypasswordmanager.controller;

import me.heesukim.mypasswordmanager.dto.AccountRequest;
import me.heesukim.mypasswordmanager.dto.AccountResponse;
import me.heesukim.mypasswordmanager.model.Account;
import me.heesukim.mypasswordmanager.repository.AccountRepository;
import me.heesukim.mypasswordmanager.service.AccountService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountRepository accountRepository;
    private final AccountService accountService;

    public AccountController(AccountRepository accountRepository, AccountService accountService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> getAccounts(Authentication authentication) {
        return accountService.getAccounts(authentication.getName());
    }

    @PostMapping
    public Account addAccount(@RequestBody AccountRequest request, Authentication authentication) {
        return accountService.createAccount(request, authentication.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountRepository.deleteById(id);
    }
}
