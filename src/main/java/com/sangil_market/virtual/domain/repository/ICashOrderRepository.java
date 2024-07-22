package com.sangil_market.virtual.domain.repository;

import com.sangil_market.virtual.domain.dto.CashOrderDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ICashOrderRepository {

    List<CashOrderDto> getAll();

    Optional<CashOrderDto> getCashOrderByDate(LocalDateTime date);

    CashOrderDto save(CashOrderDto newCashOrderDto);

    void delete(Long id);
}
