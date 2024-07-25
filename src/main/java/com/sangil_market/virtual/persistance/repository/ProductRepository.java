package com.sangil_market.virtual.persistance.repository;

import com.sangil_market.virtual.domain.dto.ProductDto;
import com.sangil_market.virtual.domain.repository.IProductRepository;
import com.sangil_market.virtual.persistance.crud.IProductCrudRepository;
import com.sangil_market.virtual.persistance.entity.Product;
import com.sangil_market.virtual.persistance.mapper.IProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProductRepository implements IProductRepository {

    private final IProductCrudRepository iProductCrudRepository;

    private final IProductMapper iProductMapper;

    @Override
    public List<ProductDto> getAll() {
        return iProductMapper.toProductDtoList(iProductCrudRepository.findAll());
    }

    @Override
    public Optional<ProductDto> getProductByName(String name) {
        return iProductCrudRepository.findByName(name).map(iProductMapper::toProductDto);
    }

    @Override
    public Optional<ProductDto> getProductByPrice(Double price) {
        return iProductCrudRepository.findByPrice(price).map(iProductMapper::toProductDto);
    }

    @Override
    public ProductDto save(ProductDto newProductDto) {
        Product product = iProductMapper.toProduct(newProductDto);
        return iProductMapper.toProductDto(iProductCrudRepository.save(product));
    }

    @Override
    public void deleteByName(String name) {
        iProductCrudRepository.deleteByName(name);
    }
}
