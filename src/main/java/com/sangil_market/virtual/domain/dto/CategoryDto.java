package com.sangil_market.virtual.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CategoryDto {

    private Long id;

    private String name;

    private List<ProductDto> products;
}
