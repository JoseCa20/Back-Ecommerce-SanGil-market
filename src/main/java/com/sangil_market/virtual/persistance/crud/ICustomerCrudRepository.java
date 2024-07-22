package com.sangil_market.virtual.persistance.crud;

import com.sangil_market.virtual.persistance.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerCrudRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
}
