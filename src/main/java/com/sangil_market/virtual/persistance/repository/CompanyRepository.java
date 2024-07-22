package com.sangil_market.virtual.persistance.repository;

import com.sangil_market.virtual.domain.dto.CompanyDto;
import com.sangil_market.virtual.domain.repository.ICompanyRepository;
import com.sangil_market.virtual.persistance.crud.ICompanyCrudRepository;
import com.sangil_market.virtual.persistance.entity.Company;
import com.sangil_market.virtual.persistance.mapper.ICompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CompanyRepository implements ICompanyRepository {

    private final ICompanyCrudRepository iCompanyCrudRepository;

    private final ICompanyMapper iCompanyMapper;

    @Override
    public List<CompanyDto> getAll() {
        return iCompanyMapper.toCompanyDtoList(iCompanyCrudRepository.findAll());
    }

    @Override
    public Optional<CompanyDto> getCompanyById(Long id) {
        return iCompanyCrudRepository.findById(id).map(iCompanyMapper::toCompanyDto);
    }

    @Override
    public Optional<CompanyDto> getCompanyByName(String username) {
        return iCompanyCrudRepository.findByUsername(username).map(iCompanyMapper::toCompanyDto);
    }

    @Override
    public CompanyDto save(CompanyDto newCompanyDto) {
        Company company = iCompanyMapper.toCompany(newCompanyDto);
        return iCompanyMapper.toCompanyDto(iCompanyCrudRepository.save(company));
    }

    @Override
    public void delete(Long id) {
        iCompanyCrudRepository.deleteById(id);
    }
}
