package com.sangil_market.virtual.persistance.crud;

import com.sangil_market.virtual.persistance.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAdministratorCrudRepository extends JpaRepository<Administrator, Long> {

    Optional<Administrator> findByEmail(String email);

    Optional<Administrator> findByRole(String role);
}
