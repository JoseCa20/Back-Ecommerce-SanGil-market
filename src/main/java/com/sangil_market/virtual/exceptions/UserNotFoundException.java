package com.sangil_market.virtual.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super("Usuario no encontrado con el nombre: " + username);
    }
}
