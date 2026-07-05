package me.heesukim.mypasswordmanager.service;

import me.heesukim.mypasswordmanager.dto.AccountRequest;
import me.heesukim.mypasswordmanager.dto.AccountResponse;
import me.heesukim.mypasswordmanager.model.Account;
import me.heesukim.mypasswordmanager.model.User;
import me.heesukim.mypasswordmanager.repository.AccountRepository;
import me.heesukim.mypasswordmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final CryptoService cryptoService;

    public AccountService(AccountRepository accountRepository,
                          UserRepository userRepository,
                          CryptoService cryptoService) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.cryptoService = cryptoService;
    }

    public Account createAccount(AccountRequest request, String username) {

        User user = userRepository.findByUsername(username);

        String encryptedPassword = cryptoService.encrypt(request.getPassword());

        Account account = new Account(
                request.getWebsite(),
                request.getUsername(),
                encryptedPassword,
                user
        );

        return accountRepository.save(account);
    }

    public List<AccountResponse> getAccounts(String username) {

        List<Account> accounts =
                accountRepository.findByUserUsername(username);

        return accounts.stream()
                .map(a -> new AccountResponse(
                        a.getId(),
                        a.getWebsite(),
                        a.getUsername(),
                        cryptoService.decrypt(a.getEncryptedPassword())
                ))
                .toList();
    }
}