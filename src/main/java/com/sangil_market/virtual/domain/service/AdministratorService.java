package com.sangil_market.virtual.domain.service;

import com.sangil_market.virtual.domain.dto.AdministratorDto;
import com.sangil_market.virtual.domain.repository.IAdministratorRepository;
import com.sangil_market.virtual.domain.useCase.IAdministratorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdministratorService implements IAdministratorUseCase {

    private final IAdministratorRepository iAdministratorRepository;

    @Override
    public List<AdministratorDto> getAll() {
        return iAdministratorRepository.getAll();
    }

    @Override
    public Optional<AdministratorDto> getAdministratorById(Long id) {
        return iAdministratorRepository.getAdministratorById(id);
    }

    @Override
    public Optional<AdministratorDto> getAdministratorByEmail(String email) {
        return iAdministratorRepository.getAdministratorByEmail(email);
    }

    @Override
    public AdministratorDto save(AdministratorDto newAdministratorDto) {
        return iAdministratorRepository.save(newAdministratorDto);
    }

    @Override
    public boolean delete(Long id) {
        if (iAdministratorRepository.getAdministratorById(id).isEmpty()){
            return false;
        }

        iAdministratorRepository.delete(id);
        return true;
    }
}
