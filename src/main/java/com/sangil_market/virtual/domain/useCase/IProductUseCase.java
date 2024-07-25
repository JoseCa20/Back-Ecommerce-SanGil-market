package com.sangil_market.virtual.domain.useCase;

import com.sangil_market.virtual.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductUseCase {

    List<ProductDto> getAll();

    Optional<ProductDto> getProductByName(String name);

    Optional<ProductDto> getProductByPrice(Double price);

    ProductDto save(ProductDto newProductDto);

    boolean deleteByName(String name);
}
