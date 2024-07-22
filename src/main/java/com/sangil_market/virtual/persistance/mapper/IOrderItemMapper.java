package com.sangil_market.virtual.persistance.mapper;

import com.sangil_market.virtual.domain.dto.OrderItemDto;
import com.sangil_market.virtual.persistance.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderItemMapper {

    OrderItemDto toOrderItemDto(OrderItem orderItem);

    @Mapping(target = "cashOrder", ignore = true)
    OrderItem toOrderItem(OrderItemDto orderItemDto);

    List<OrderItemDto> toOrderItemDtoList(List<OrderItem> orderItemList);

}
