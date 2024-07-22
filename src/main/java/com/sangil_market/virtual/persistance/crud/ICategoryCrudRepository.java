package com.sangil_market.virtual.persistance.crud;

import com.sangil_market.virtual.persistance.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryCrudRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);
}
