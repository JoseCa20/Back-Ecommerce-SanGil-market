package com.sangil_market.virtual.domain.service;

import com.sangil_market.virtual.domain.dto.ProductDto;
import com.sangil_market.virtual.domain.repository.IProductRepository;
import com.sangil_market.virtual.domain.useCase.IProductUseCase;
import com.sangil_market.virtual.exceptions.ResourceAlreadyExists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductUseCase {

    private final IProductRepository iProductRepository;

    @Override
    public List<ProductDto> getAll() {
        return iProductRepository.getAll();
    }

    @Override
    public Optional<ProductDto> getProductByName(String name) {
        return iProductRepository.getProductByName(name);
    }

    @Override
    public Optional<ProductDto> getProductByPrice(Double price) {
        return iProductRepository.getProductByPrice(price);
    }

    @Override
    public ProductDto save(ProductDto newProductDto) {
        if (iProductRepository.getProductByName(newProductDto.getName()).isEmpty()){
            throw new ResourceAlreadyExists();
        }
        return iProductRepository.save(newProductDto);
    }

    @Override
    public boolean deleteByName(String name) {
        if (iProductRepository.getProductByName(name).isEmpty()){
            return false;
        }
        iProductRepository.deleteByName(name);
        return true;
    }
}
