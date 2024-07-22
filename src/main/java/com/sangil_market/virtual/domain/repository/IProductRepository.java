package com.sangil_market.virtual.domain.repository;

import com.sangil_market.virtual.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {

    List<ProductDto> getAll();

    Optional<ProductDto> getProductByName(String name);

    Optional<ProductDto> getProductByPrice(Double price);

    ProductDto save(ProductDto newProductDto);

    void delete(Long id);
}
