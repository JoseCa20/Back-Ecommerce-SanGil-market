package com.sangil_market.virtual.domain.repository;

import com.sangil_market.virtual.domain.dto.AdministratorDto;

import java.util.List;
import java.util.Optional;

public interface IAdministratorRepository {

    List<AdministratorDto> getAll();

    Optional<AdministratorDto> getAdministratorById(Long id);

    Optional<AdministratorDto> getAdministratorByEmail(String email);

    AdministratorDto save(AdministratorDto newAdministratorDto);

    void delete(Long id);
}
