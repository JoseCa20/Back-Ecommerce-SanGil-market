package com.sangil_market.virtual.domain.repository;

import com.sangil_market.virtual.domain.dto.CompanyDto;

import java.util.List;
import java.util.Optional;

public interface ICompanyRepository {

    List<CompanyDto> getAll();

    Optional<CompanyDto> getCompanyById(Long id);

    Optional<CompanyDto> getCompanyByName(String username);

    CompanyDto save(CompanyDto newCompanyDto);

    void delete(Long id);
}
