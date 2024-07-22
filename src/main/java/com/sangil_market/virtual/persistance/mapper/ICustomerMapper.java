package com.sangil_market.virtual.persistance.mapper;

import com.sangil_market.virtual.domain.dto.CustomerDto;
import com.sangil_market.virtual.persistance.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICustomerMapper{

    CustomerDto toCustomerDto(Customer customer);

    @Mapping(target = "cashOrders", ignore = true)
    Customer toCustomer(CustomerDto customerDto);

    List<CustomerDto> toCustomerDtoList(List<Customer> customerList);
}
