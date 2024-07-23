package com.sangil_market.virtual.persistance.repository;

import com.sangil_market.virtual.domain.dto.UserDto;
import com.sangil_market.virtual.domain.repository.IUserRepository;
import com.sangil_market.virtual.persistance.crud.IUserCrudRepository;
import com.sangil_market.virtual.persistance.entity.User;
import com.sangil_market.virtual.persistance.mapper.IUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepository implements IUserRepository {

    private final IUserCrudRepository iUserCrudRepository;

    private final IUserMapper iUserMapper;

    @Override
    public List<UserDto> getAll() {
        return iUserMapper.toUserDtoList(iUserCrudRepository.findAll());
    }

    @Override
    public Optional<UserDto> getUserByIdCard(Long idCard) {
        return iUserCrudRepository.findById(idCard).map(iUserMapper::toUserDto);
    }

    @Override
    public Optional<UserDto> getUserByEmail(String email) {
        return iUserCrudRepository.findByEmail(email).map(iUserMapper::toUserDto);
    }

    @Override
    public Optional<UserDto> getUserByRole(String role) {
        return iUserCrudRepository.findByRole(role).map(iUserMapper::toUserDto);
    }

    @Override
    public UserDto save(UserDto newUserDto) {
        User user = iUserMapper.toUser(newUserDto);
        return iUserMapper.toUserDto(iUserCrudRepository.save(user));
    }

    @Override
    public void delete(Long idCard) {
        iUserCrudRepository.deleteById(idCard);
    }
}
