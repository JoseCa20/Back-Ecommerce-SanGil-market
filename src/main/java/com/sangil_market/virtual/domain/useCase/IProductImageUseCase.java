package com.sangil_market.virtual.domain.useCase;

import com.sangil_market.virtual.domain.dto.ProductImageDto;

import java.util.List;
import java.util.Optional;

public interface IProductImageUseCase {

    List<ProductImageDto> getAll();

    Optional<ProductImageDto> getProductImageByUrl(String imageUrl);

    ProductImageDto save(ProductImageDto newProductImageDto);

    Optional<ProductImageDto> update(ProductImageDto updateProductImageDto);

    boolean deleteByImageUrl(String imageUrl);
}
