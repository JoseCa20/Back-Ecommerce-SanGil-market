package com.sangil_market.virtual.persistance.mapper;

import com.sangil_market.virtual.domain.dto.CategoryDto;
import com.sangil_market.virtual.persistance.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {

    CategoryDto toCategoryDto(Category category);

    Category toCategory (CategoryDto categoryDto);

    List<CategoryDto> toCategoryDtoList(List<Category> categoryList);
}
