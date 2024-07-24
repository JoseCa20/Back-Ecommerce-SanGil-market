package com.sangil_market.virtual.domain.service;

import com.sangil_market.virtual.domain.dto.AdministratorDto;
import com.sangil_market.virtual.domain.repository.IAdministratorRepository;
import com.sangil_market.virtual.domain.useCase.IAdministratorUseCase;
import com.sangil_market.virtual.exceptions.EmailValidationException;
import com.sangil_market.virtual.exceptions.UserAlreadyExistsException;
import com.sangil_market.virtual.persistance.entity.Administrator;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdministratorService implements IAdministratorUseCase {

    private final IAdministratorRepository iAdministratorRepository;

    private final PasswordEncoder passwordEncoder;

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
    public Optional<AdministratorDto> getAdministratorByRole(String role) {
        return iAdministratorRepository.getAdministratorByRole(role);
    }


    @Override
    public AdministratorDto save(AdministratorDto newAdministratorDto) {

        if (!newAdministratorDto.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailValidationException();
        }

        if (iAdministratorRepository.getAdministratorById(newAdministratorDto.getIdCard()).isPresent() ||
                iAdministratorRepository.getAdministratorByEmail(newAdministratorDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        String passwordGenerated = newAdministratorDto.getPassword();
        newAdministratorDto.setPassword(passwordEncoder.encode(passwordGenerated));
        newAdministratorDto.setRole("SUB-ADMIN");

        iAdministratorRepository.save(newAdministratorDto);

        return newAdministratorDto;

    }


    @Override
    public boolean delete(Long id) {
        if (iAdministratorRepository.getAdministratorById(id).isEmpty()){
            return false;
        }

        iAdministratorRepository.delete(id);
        return true;
    }

    private String generateRandomPassword(int len){
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz012345689";

        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i++){
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
