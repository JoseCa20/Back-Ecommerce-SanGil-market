package com.sangil_market.virtual.domain.service;

import com.sangil_market.virtual.domain.dto.UserDto;
import com.sangil_market.virtual.domain.repository.IUserRepository;
import com.sangil_market.virtual.domain.useCase.IUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserUseCase {

    private final IUserRepository iUserRepository;

    @Override
    public List<UserDto> getAll() {
        return iUserRepository.getAll();
    }

    @Override
    public Optional<UserDto> getUserByIdCard(Long idCard) {
        return iUserRepository.getUserByIdCard(idCard);
    }

    @Override
    public Optional<UserDto> getUserByEmail(String email) {
        return iUserRepository.getUserByEmail(email);
    }

    @Override
    public Optional<UserDto> getUserByRole(String role) {
        return iUserRepository.getUserByRole(role);
    }

    @Override
    public UserDto save(UserDto newUserDto) {
        return iUserRepository.save(newUserDto);
    }

    @Override
    public Optional<UserDto> update(UserDto updateCustomer) {
        if (iUserRepository.getUserByIdCard(updateCustomer.getIdCard()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iUserRepository.save(updateCustomer));
    }

    @Override
    public boolean delete(Long idCard) {
        if (iUserRepository.getUserByIdCard(idCard).isEmpty()){
            return false;
        }

        iUserRepository.delete(idCard);
        return true;
    }
}
