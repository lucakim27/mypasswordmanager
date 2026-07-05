package me.heesukim.mypasswordmanager.repository;

import me.heesukim.mypasswordmanager.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByUserUsername(String username);
}