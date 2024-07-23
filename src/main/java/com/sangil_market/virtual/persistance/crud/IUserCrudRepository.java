package com.sangil_market.virtual.persistance.crud;

import com.sangil_market.virtual.persistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserCrudRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByRole(String role);
}
