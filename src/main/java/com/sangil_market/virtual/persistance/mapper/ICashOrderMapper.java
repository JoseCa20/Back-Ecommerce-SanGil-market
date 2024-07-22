package com.sangil_market.virtual.persistance.mapper;

import com.sangil_market.virtual.domain.dto.CashOrderDto;
import com.sangil_market.virtual.persistance.entity.CashOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICashOrderMapper {

    CashOrderDto toCashOrderDto(CashOrder cashOrder);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "orderItems", ignore = true)
    CashOrder toCashOrder(CashOrderDto cashOrderDto);

    List<CashOrderDto> toCashOrderDtoList(List<CashOrder> cashOrderList);
}
