package com.sangil_market.virtual.persistance.crud;

import com.sangil_market.virtual.persistance.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductImageCrudRepository extends JpaRepository<ProductImage, Long> {

    Optional<ProductImage> findByImageUrl(String url);
}
