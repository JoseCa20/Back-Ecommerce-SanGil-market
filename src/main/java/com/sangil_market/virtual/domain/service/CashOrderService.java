package com.sangil_market.virtual.domain.service;

import com.sangil_market.virtual.domain.dto.CashOrderDto;
import com.sangil_market.virtual.domain.repository.ICashOrderRepository;
import com.sangil_market.virtual.domain.useCase.ICashOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CashOrderService implements ICashOrderUseCase {

    private final ICashOrderRepository iCashOrderRepository;

    @Override
    public List<CashOrderDto> getAll() {
        return iCashOrderRepository.getAll();
    }

    @Override
    public Optional<CashOrderDto> getCashOrderById(Long id) {
        return iCashOrderRepository.getCashOrderById(id);
    }

    @Override
    public Optional<CashOrderDto> getCashOrderByDate(LocalDateTime date) {
        return iCashOrderRepository.getCashOrderByDate(date);
    }

    @Override
    public CashOrderDto save(CashOrderDto newCashOrderDto) {
        return iCashOrderRepository.save(newCashOrderDto);
    }

    @Override
    public Optional<CashOrderDto> update(CashOrderDto updateCashOrderDto) {
        if (iCashOrderRepository.getCashOrderById(updateCashOrderDto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCashOrderRepository.save(updateCashOrderDto));
    }

    @Override
    public boolean delete(Long id) {
        if (iCashOrderRepository.getCashOrderById(id).isEmpty()){
            return false;
        }iCashOrderRepository.delete(id);
        return true;
    }
}
