package com.sangil_market.virtual.domain.repository;

import com.sangil_market.virtual.domain.dto.OrderItemDto;

import java.util.List;
import java.util.Optional;

public interface IOrderItemRepository {

    List<OrderItemDto> getAll();

    Optional<OrderItemDto> getOrderItemById(Long id);

    OrderItemDto save(OrderItemDto newOrderItemDto);

    void delete(Long id);
}
