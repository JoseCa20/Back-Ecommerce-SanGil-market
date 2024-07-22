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
    public Optional<UserDto> getUser(Long id) {
        return iUserRepository.getUser(id);
    }

    @Override
    public Optional<UserDto> getUserByEmail(String email) {
        return iUserRepository.getUserByEmail(email);
    }

    @Override
    public UserDto save(UserDto newUserDto) {
        return iUserRepository.save(newUserDto);
    }

    @Override
    public boolean delete(Long id) {
        if (iUserRepository.getUser(id).isEmpty()){
            return false;
        }

        iUserRepository.delete(id);
        return true;
    }
}
