package com.sangil_market.virtual.domain.useCase;

import com.sangil_market.virtual.domain.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface ICategoryUseCase {

    List<CategoryDto> getAll();

    Optional<CategoryDto> getCategoryByName(String name);

    CategoryDto save(CategoryDto newCategoryDto);

    boolean delete(String name);
}
