package com.sangil_market.virtual.persistance.mapper;

import com.sangil_market.virtual.domain.dto.ProductImageDto;
import com.sangil_market.virtual.persistance.entity.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductImageMapper {

    ProductImageDto toProductImageDto(ProductImage productImage);

    @Mapping(target = "product", ignore = true)
    ProductImage toProductImage(ProductImageDto productImageDto);

    List<ProductImageDto> toProductImageDtoList(List<ProductImage> productImageList);
}
