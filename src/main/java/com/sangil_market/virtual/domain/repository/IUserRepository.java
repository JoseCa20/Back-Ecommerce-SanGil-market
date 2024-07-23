package com.sangil_market.virtual.domain.repository;

import com.sangil_market.virtual.domain.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    List<UserDto> getAll();

    Optional<UserDto> getUserByIdCard(Long idCard);

    Optional<UserDto> getUserByEmail(String email);

    Optional<UserDto> getUserByRole(String role);

    UserDto save(UserDto newUserDto);

    void delete(Long idCard);
}
