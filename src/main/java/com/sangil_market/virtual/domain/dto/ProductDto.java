package com.sangil_market.virtual.domain.dto;

import com.sangil_market.virtual.persistance.entity.Category;
import com.sangil_market.virtual.persistance.entity.Company;
import com.sangil_market.virtual.persistance.entity.ProductImage;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer stock;

    private CategoryDto category;

    private CompanyDto company;

    private List<ProductImageDto> productImages;

}
