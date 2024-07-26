package com.sangil_market.virtual.domain.useCase;

import com.sangil_market.virtual.domain.dto.OrderItemDto;

import java.util.List;
import java.util.Optional;

public interface IOrderItemUseCase {

    List<OrderItemDto> getAll();

    Optional<OrderItemDto> getOrderItemById(Long id);

    OrderItemDto save(OrderItemDto newOrderItemDto);

    Optional<OrderItemDto> update(OrderItemDto updateOrderItemDto);

    boolean delete(Long id);
}
