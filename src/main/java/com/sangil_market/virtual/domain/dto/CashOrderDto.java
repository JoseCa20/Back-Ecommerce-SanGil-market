package com.sangil_market.virtual.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class CashOrderDto {

    private Long id;

    private LocalDateTime date;

    private Double total;

    private String state;

}
