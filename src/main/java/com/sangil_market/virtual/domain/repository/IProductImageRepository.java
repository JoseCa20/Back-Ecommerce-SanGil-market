package com.sangil_market.virtual.domain.repository;

import com.sangil_market.virtual.domain.dto.ProductImageDto;

import java.util.List;
import java.util.Optional;

public interface IProductImageRepository {

    List<ProductImageDto> getAll();

    Optional<ProductImageDto> getProductImageByUrl(String imageUrl);

    ProductImageDto save(ProductImageDto newProductImageDto);

    void delete(Long id);
}
