package com.sangil_market.virtual.persistance.repository;

import com.sangil_market.virtual.domain.dto.CategoryDto;
import com.sangil_market.virtual.domain.repository.ICategoryRepository;
import com.sangil_market.virtual.persistance.crud.ICategoryCrudRepository;
import com.sangil_market.virtual.persistance.entity.Category;
import com.sangil_market.virtual.persistance.mapper.ICategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CategoryRepository implements ICategoryRepository {

    private final ICategoryCrudRepository iCategoryCrudRepository;

    private final ICategoryMapper iCategoryMapper;

    @Override
    public List<CategoryDto> getAll() {
        return iCategoryMapper.toCategoryDtoList(iCategoryCrudRepository.findAll());
    }

    @Override
    public Optional<CategoryDto> getCategoryByName(String name) {
        return iCategoryCrudRepository.findByName(name).map(iCategoryMapper::toCategoryDto);
    }

    @Override
    public CategoryDto save(CategoryDto newCategoryDto) {
        Category category = iCategoryMapper.toCategory(newCategoryDto);
        return iCategoryMapper.toCategoryDto(iCategoryCrudRepository.save(category));
    }

    @Override
    public void delete(Long id) {
        iCategoryCrudRepository.deleteById(id);
    }
}
