package com.sangil_market.virtual.domain.service;

import com.sangil_market.virtual.domain.dto.OrderItemDto;
import com.sangil_market.virtual.domain.repository.IOrderItemRepository;
import com.sangil_market.virtual.domain.useCase.IOrderItemUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderItemService implements IOrderItemUseCase {

    private final IOrderItemRepository iOrderItemRepository;

    @Override
    public List<OrderItemDto> getAll() {
        return iOrderItemRepository.getAll();
    }

    @Override
    public Optional<OrderItemDto> getOrderItemById(Long id) {
        return iOrderItemRepository.getOrderItemById(id);
    }

    @Override
    public OrderItemDto save(OrderItemDto newOrderItemDto) {
        return iOrderItemRepository.save(newOrderItemDto);
    }

    @Override
    public Optional<OrderItemDto> update(OrderItemDto updateOrderItemDto) {
        if (iOrderItemRepository.getOrderItemById(updateOrderItemDto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iOrderItemRepository.save(updateOrderItemDto));
    }

    @Override
    public boolean delete(Long id) {
        if (iOrderItemRepository.getOrderItemById(id).isEmpty()){
            return false;
        }
        iOrderItemRepository.delete(id);
        return true;
    }
}
