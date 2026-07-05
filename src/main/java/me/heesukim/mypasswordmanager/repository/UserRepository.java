package me.heesukim.mypasswordmanager.repository;

import me.heesukim.mypasswordmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
