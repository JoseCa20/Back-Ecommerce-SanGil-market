package com.sangil_market.virtual.persistance.mapper;

import com.sangil_market.virtual.domain.dto.AdministratorDto;
import com.sangil_market.virtual.persistance.entity.Administrator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAdministratorMapper {

    AdministratorDto toAdministratorDto(Administrator administrator);

    @Mapping(target = "cashOrders", ignore = true)
    Administrator toAdministrator(AdministratorDto administratorDto);

    List<AdministratorDto> administratorDtoList(List<Administrator> administratorList);
}
