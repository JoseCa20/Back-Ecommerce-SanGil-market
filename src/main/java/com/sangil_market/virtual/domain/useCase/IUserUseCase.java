package com.sangil_market.virtual.domain.useCase;

import com.sangil_market.virtual.domain.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserUseCase {

    List<UserDto> getAll();

    Optional<UserDto> getUserByIdCard(Long idCard);

    Optional<UserDto> getUserByEmail(String email);

    Optional<UserDto> getUserByRole(String role);

    UserDto save(UserDto newUserDto);

    Optional<UserDto> update(UserDto modifyCustomer);

    boolean delete(Long idCard);
}
