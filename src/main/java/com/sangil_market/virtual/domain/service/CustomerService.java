package com.sangil_market.virtual.domain.service;

import com.sangil_market.virtual.domain.dto.CustomerDto;
import com.sangil_market.virtual.domain.repository.ICustomerRepository;
import com.sangil_market.virtual.domain.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerUseCase {

    private final ICustomerRepository iCustomerRepository;


    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerById(Long id) {
        return iCustomerRepository.getCustomerById(id);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public CustomerDto save(CustomerDto newCustomerDto) {
        return iCustomerRepository.save(newCustomerDto);
    }

    @Override
    public boolean delete(Long id) {
        if (iCustomerRepository.getCustomerById(id).isEmpty()){
            return false;
        }

        iCustomerRepository.delete(id);
        return true;
    }
}
