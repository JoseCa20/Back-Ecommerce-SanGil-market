package com.sangil_market.virtual.domain.service;

import com.sangil_market.virtual.domain.dto.ProductImageDto;
import com.sangil_market.virtual.domain.repository.IProductImageRepository;
import com.sangil_market.virtual.domain.useCase.IProductImageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductImageService implements IProductImageUseCase {

    private final IProductImageRepository iProductImageRepository;

    @Override
    public List<ProductImageDto> getAll() {
        return iProductImageRepository.getAll();
    }

    @Override
    public Optional<ProductImageDto> getProductImageByUrl(String imageUrl) {
        return iProductImageRepository.getProductImageByUrl(imageUrl);
    }

    @Override
    public ProductImageDto save(ProductImageDto newProductImageDto) {
        return iProductImageRepository.save(newProductImageDto);
    }

    @Override
    public boolean deleteByImageUrl(String imageUrl) {
        if (iProductImageRepository.getProductImageByUrl(imageUrl).isEmpty()){
            return false;
        }
        iProductImageRepository.getProductImageByUrl(imageUrl);
        return true;
    }
}
