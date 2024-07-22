package com.sangil_market.virtual.domain.useCase;

import com.sangil_market.virtual.domain.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserUseCase {

    List<UserDto> getAll();

    Optional<UserDto> getUser(Long id);

    Optional<UserDto> getUserByEmail(String email);

    UserDto save(UserDto newUserDto);

    boolean delete(Long id);
}
