package com.sangil_market.virtual.domain.useCase;

import com.sangil_market.virtual.domain.dto.AdministratorDto;

import java.util.List;
import java.util.Optional;

public interface IAdministratorUseCase {

    List<AdministratorDto> getAll();

    Optional<AdministratorDto> getAdministratorById(Long id);

    Optional<AdministratorDto> getAdministratorByEmail(String email);

    AdministratorDto save(AdministratorDto newAdministratorDto);

    boolean delete(Long id);
}
