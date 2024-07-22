package com.sangil_market.virtual.persistance.mapper;

import com.sangil_market.virtual.domain.dto.CompanyDto;
import com.sangil_market.virtual.persistance.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICompanyMapper {

    CompanyDto toCompanyDto(Company company);

    @Mapping(target = "products", ignore = true)
    @Mapping(target = "cashOrders", ignore = true)
    Company toCompany(CompanyDto companyDto);

    List<CompanyDto> toCompanyDtoList(List<Company> companyList);
}
