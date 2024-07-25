package com.sangil_market.virtual.persistance.repository;

import com.sangil_market.virtual.domain.dto.ProductImageDto;
import com.sangil_market.virtual.domain.repository.IProductImageRepository;
import com.sangil_market.virtual.persistance.crud.IProductImageCrudRepository;
import com.sangil_market.virtual.persistance.entity.ProductImage;
import com.sangil_market.virtual.persistance.mapper.IProductImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProductImageRepository implements IProductImageRepository {

    private final IProductImageCrudRepository iProductImageCrudRepository;

    private final IProductImageMapper iProductImageMapper;

    @Override
    public List<ProductImageDto> getAll() {
        return iProductImageMapper.toProductImageDtoList(iProductImageCrudRepository.findAll());
    }

    @Override
    public Optional<ProductImageDto> getProductImageByUrl(String imageUrl) {
        return iProductImageCrudRepository.findByImageUrl(imageUrl).map(iProductImageMapper::toProductImageDto);
    }

    @Override
    public ProductImageDto save(ProductImageDto newProductImageDto) {
        ProductImage productImage = iProductImageMapper.toProductImage(newProductImageDto);
        return iProductImageMapper.toProductImageDto(iProductImageCrudRepository.save(productImage));
    }

    @Override
    public void deleteByImageUrl(String imageUrl) {
        iProductImageCrudRepository.deleteByImageUrl(imageUrl);
    }
}
