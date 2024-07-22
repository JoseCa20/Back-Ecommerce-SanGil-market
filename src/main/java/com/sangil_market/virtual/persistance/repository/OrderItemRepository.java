package com.sangil_market.virtual.persistance.repository;

import com.sangil_market.virtual.domain.dto.OrderItemDto;
import com.sangil_market.virtual.domain.repository.IOrderItemRepository;
import com.sangil_market.virtual.persistance.crud.IOrderItemCrudRepository;
import com.sangil_market.virtual.persistance.entity.OrderItem;
import com.sangil_market.virtual.persistance.mapper.IOrderItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class OrderItemRepository implements IOrderItemRepository {

    private final IOrderItemCrudRepository iOrderItemCrudRepository;

    private final IOrderItemMapper iOrderItemMapper;

    @Override
    public List<OrderItemDto> getAll() {
        return iOrderItemMapper.toOrderItemDtoList(iOrderItemCrudRepository.findAll());
    }

    @Override
    public Optional<OrderItemDto> getOrderItemById(Long id) {
        return iOrderItemCrudRepository.findById(id).map(iOrderItemMapper::toOrderItemDto);
    }

    @Override
    public OrderItemDto save(OrderItemDto newOrderItemDto) {
        OrderItem orderItem = iOrderItemMapper.toOrderItem(newOrderItemDto);
        return iOrderItemMapper.toOrderItemDto(iOrderItemCrudRepository.save(orderItem));
    }

    @Override
    public void delete(Long id) {
        iOrderItemCrudRepository.deleteById(id);
    }
}
