package com.sangil_market.virtual.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {

    private Long id;

    private String username;

    private String address;

    private String email;

    private String password;

    private String phone;

    private String role;
}
