package me.heesukim.mypasswordmanager.controller;

import me.heesukim.mypasswordmanager.dto.AccountRequest;
import me.heesukim.mypasswordmanager.model.Account;
import me.heesukim.mypasswordmanager.model.User;
import me.heesukim.mypasswordmanager.repository.AccountRepository;
import me.heesukim.mypasswordmanager.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountController(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Account> getAccounts(Authentication authentication) {
        return accountRepository.findByUserUsername(authentication.getName());
    }

    @PostMapping
    public Account addAccount(@RequestBody AccountRequest request, Authentication authentication) {

        String username = authentication.getName();

        User user = userRepository.findByUsername(username);

        Account account = new Account(
                request.getWebsite(),
                request.getUsername(),
                request.getPassword(),
                user
        );

        return accountRepository.save(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountRepository.deleteById(id);
    }
}
