package com.sangil_market.virtual.persistance.mapper;

import com.sangil_market.virtual.domain.dto.ProductDto;
import com.sangil_market.virtual.persistance.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    ProductDto toProductDto(Product product);

    @Mapping(target = "orderItems", ignore = true)
    Product toProduct(ProductDto productDto);

    List<ProductDto> toProductDtoList(List<Product> productList);
}
