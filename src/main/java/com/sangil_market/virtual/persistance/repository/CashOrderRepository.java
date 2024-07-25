package com.sangil_market.virtual.persistance.repository;

import com.sangil_market.virtual.domain.dto.CashOrderDto;
import com.sangil_market.virtual.domain.repository.ICashOrderRepository;
import com.sangil_market.virtual.persistance.crud.ICashOrderCrudRepository;
import com.sangil_market.virtual.persistance.entity.CashOrder;
import com.sangil_market.virtual.persistance.mapper.ICashOrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CashOrderRepository implements ICashOrderRepository {

    private final ICashOrderCrudRepository iCashOrderCrudRepository;

    private final ICashOrderMapper iCashOrderMapper;

    @Override
    public List<CashOrderDto> getAll() {
        return iCashOrderMapper.toCashOrderDtoList(iCashOrderCrudRepository.findAll());
    }

    @Override
    public Optional<CashOrderDto> getCashOrderById(Long id) {
        return iCashOrderCrudRepository.getCashOrderById(id).map(iCashOrderMapper::toCashOrderDto);
    }

    @Override
    public Optional<CashOrderDto> getCashOrderByDate(LocalDateTime date) {
        return iCashOrderCrudRepository.findByDate(date).map(iCashOrderMapper::toCashOrderDto);
    }

    @Override
    public CashOrderDto save(CashOrderDto newCashOrderDto) {
        CashOrder cashOrder = iCashOrderMapper.toCashOrder(newCashOrderDto);
        return iCashOrderMapper.toCashOrderDto(iCashOrderCrudRepository.save(cashOrder));
    }

    @Override
    public void delete(Long id) {
        iCashOrderCrudRepository.deleteById(id);
    }
}
