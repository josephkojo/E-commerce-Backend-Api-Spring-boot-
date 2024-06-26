package com.Ecomence.Ecommece.Repository;

import com.Ecomence.Ecommece.Entities.User;
import com.Ecomence.Ecommece.Enum.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Boolean existsByRole(Role role);
}
