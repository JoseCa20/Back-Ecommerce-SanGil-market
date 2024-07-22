package com.sangil_market.virtual.persistance.repository;

import com.sangil_market.virtual.domain.dto.CustomerDto;
import com.sangil_market.virtual.domain.repository.ICustomerRepository;
import com.sangil_market.virtual.persistance.crud.ICustomerCrudRepository;
import com.sangil_market.virtual.persistance.entity.Customer;
import com.sangil_market.virtual.persistance.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {

   private final ICustomerCrudRepository iCustomerCrudRepository;

   private final ICustomerMapper iCustomerMapper;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerMapper.toCustomerDtoList(iCustomerCrudRepository.findAll());
    }

    @Override
    public Optional<CustomerDto> getCustomerById(Long id) {
        return iCustomerCrudRepository.findById(id).map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerCrudRepository.findByEmail(email).map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto newCustomerDto) {
        Customer customer = iCustomerMapper.toCustomer(newCustomerDto);
        return iCustomerMapper.toCustomerDto(iCustomerCrudRepository.save(customer));
    }

    @Override
    public void delete(Long id) {
        iCustomerCrudRepository.deleteById(id);
    }
}
