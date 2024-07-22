package com.sangil_market.virtual.domain.useCase;

import com.sangil_market.virtual.domain.dto.CompanyDto;

import java.util.List;
import java.util.Optional;

public interface ICompanyUseCase {

    List<CompanyDto> getAll();

    Optional<CompanyDto> getCompanyById(Long id);

    Optional<CompanyDto> getCompanyByName(String username);

    CompanyDto save(CompanyDto newCompanyDto);

    boolean delete(Long id);
}
