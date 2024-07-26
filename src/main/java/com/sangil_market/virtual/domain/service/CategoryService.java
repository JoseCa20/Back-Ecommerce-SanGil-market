package com.sangil_market.virtual.domain.service;

import com.sangil_market.virtual.domain.dto.CategoryDto;
import com.sangil_market.virtual.domain.repository.ICategoryRepository;
import com.sangil_market.virtual.domain.useCase.ICategoryUseCase;
import com.sangil_market.virtual.exceptions.ResourceAlreadyExists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService implements ICategoryUseCase {

    private final ICategoryRepository iCategoryRepository;

    @Override
    public List<CategoryDto> getAll() {
        return iCategoryRepository.getAll();
    }

    @Override
    public Optional<CategoryDto> getCategoryByName(String name) {
        return iCategoryRepository.getCategoryByName(name);
    }

    @Override
    public CategoryDto save(CategoryDto newCategoryDto) {
        if (iCategoryRepository.getCategoryByName(newCategoryDto.getName()).isPresent()){
            throw  new ResourceAlreadyExists();
        }
        return iCategoryRepository.save(newCategoryDto);
    }

    @Override
    public Optional<CategoryDto> update(CategoryDto updateCategoryDto) {
        if (iCategoryRepository.getCategoryByName(updateCategoryDto.getName()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCategoryRepository.save(updateCategoryDto));
    }

    @Override
    public boolean delete(String name) {
        if (iCategoryRepository.getCategoryByName(name).isEmpty()){
            return false;
        }
        iCategoryRepository.delete(name);
        return true;
    }
}
