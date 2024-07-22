package com.sangil_market.virtual.domain.repository;

import com.sangil_market.virtual.domain.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository {

    List<CategoryDto> getAll();

    Optional<CategoryDto> getCategoryByName(String name);

    CategoryDto save(CategoryDto newCategoryDto);

    void delete(Long id);
}
