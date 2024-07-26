package com.sangil_market.virtual.domain.useCase;

import com.sangil_market.virtual.domain.dto.AssessmentDto;
import com.sangil_market.virtual.domain.dto.CashOrderDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ICashOrderUseCase {

    List<CashOrderDto> getAll();

    Optional<CashOrderDto> getCashOrderById(Long id);

    Optional<CashOrderDto> getCashOrderByDate(LocalDateTime date);

    CashOrderDto save(CashOrderDto newCashOrderDto);

    Optional<CashOrderDto> update(CashOrderDto updateCashOrderDto);

    boolean delete(Long id);
}
