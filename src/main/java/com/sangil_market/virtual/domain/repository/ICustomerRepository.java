package com.sangil_market.virtual.domain.repository;

import com.sangil_market.virtual.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {

    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerById(Long id);

    Optional<CustomerDto> getCustomerByEmail(String email);

    CustomerDto save(CustomerDto newCustomerDto);

    void delete(Long id);
}
