package com.sangil_market.virtual.persistance.crud;

import com.sangil_market.virtual.persistance.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductCrudRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    Optional<Product> findByPrice(Double name);

    void deleteByName(String name);


}
