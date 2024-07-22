package com.sangil_market.virtual.persistance.mapper;

import com.sangil_market.virtual.domain.dto.UserDto;
import com.sangil_market.virtual.persistance.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    UserDto toUserDto(User userEntity);

    @Mapping(target = "cashOrders", ignore = true)
    User toUser(UserDto administatorDto);

    List<UserDto> toUserDtoList(List<User> userList);
}
