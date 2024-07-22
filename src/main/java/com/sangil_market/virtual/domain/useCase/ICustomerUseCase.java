package com.sangil_market.virtual.domain.useCase;

import com.sangil_market.virtual.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerUseCase {

    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerById(Long id);

    Optional<CustomerDto> getCustomerByEmail(String email);

    CustomerDto save(CustomerDto newCustomerDto);

    boolean delete(Long id);
}
