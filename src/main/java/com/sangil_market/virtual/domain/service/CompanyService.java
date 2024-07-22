package com.sangil_market.virtual.domain.service;

import com.sangil_market.virtual.domain.dto.AdministratorDto;
import com.sangil_market.virtual.domain.dto.CompanyDto;
import com.sangil_market.virtual.domain.repository.ICompanyRepository;
import com.sangil_market.virtual.domain.useCase.IAdministratorUseCase;
import com.sangil_market.virtual.domain.useCase.ICompanyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyService implements ICompanyUseCase {

    private final ICompanyRepository iCompanyRepository;

    @Override
    public List<CompanyDto> getAll() {
        return iCompanyRepository.getAll();
    }

    @Override
    public Optional<CompanyDto> getCompanyById(Long id) {
        return iCompanyRepository.getCompanyById(id);
    }

    @Override
    public Optional<CompanyDto> getCompanyByName(String username) {
        return iCompanyRepository.getCompanyByName(username);
    }

    @Override
    public CompanyDto save(CompanyDto newCompanyDto) {
        return iCompanyRepository.save(newCompanyDto);
    }

    @Override
    public boolean delete(Long id) {
        if (iCompanyRepository.getCompanyById(id).isEmpty()){
            return false;
        }

        iCompanyRepository.delete(id);
        return true;
    }
}
