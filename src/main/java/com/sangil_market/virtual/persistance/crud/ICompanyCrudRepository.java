package com.sangil_market.virtual.persistance.crud;

import com.sangil_market.virtual.persistance.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICompanyCrudRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByUsername(String username);
}
