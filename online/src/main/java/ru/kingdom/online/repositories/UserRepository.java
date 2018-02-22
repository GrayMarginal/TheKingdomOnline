package ru.kingdom.online.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kingdom.online.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
