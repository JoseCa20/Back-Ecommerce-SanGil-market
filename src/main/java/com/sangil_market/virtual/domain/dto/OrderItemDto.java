package com.sangil_market.virtual.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderItemDto {

    private Long id;

    private int quantity;

    private double price;

    private ProductDto product;

}
