package com.sangil_market.virtual.persistance.repository;

import com.sangil_market.virtual.domain.dto.AdministratorDto;
import com.sangil_market.virtual.domain.repository.IAdministratorRepository;
import com.sangil_market.virtual.persistance.crud.IAdministratorCrudRepository;
import com.sangil_market.virtual.persistance.entity.Administrator;
import com.sangil_market.virtual.persistance.mapper.IAdministratorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class AdministratorRepository implements IAdministratorRepository {

    private final IAdministratorCrudRepository iAdministratorCrudRepository;

    private final IAdministratorMapper iAdministratorMapper;

    @Override
    public List<AdministratorDto> getAll() {
        return iAdministratorMapper.administratorDtoList(iAdministratorCrudRepository.findAll());
    }

    @Override
    public Optional<AdministratorDto> getAdministratorById(Long id) {
        return iAdministratorCrudRepository.findById(id).map(iAdministratorMapper::toAdministratorDto);
    }

    @Override
    public Optional<AdministratorDto> getAdministratorByEmail(String email) {
        return iAdministratorCrudRepository.findByEmail(email).map(iAdministratorMapper::toAdministratorDto);
    }

    @Override
    public Optional<AdministratorDto> getAdministratorByRole(String role) {
        return iAdministratorCrudRepository.findByRole(role).map(iAdministratorMapper::toAdministratorDto);
    }

    @Override
    public AdministratorDto save(AdministratorDto newAdministratorDto) {
        Administrator administrator = iAdministratorMapper.toAdministrator(newAdministratorDto);
        return iAdministratorMapper.toAdministratorDto(iAdministratorCrudRepository.save(administrator));
    }

    @Override
    public void delete(Long id) {
        iAdministratorCrudRepository.deleteById(id);
    }
}
