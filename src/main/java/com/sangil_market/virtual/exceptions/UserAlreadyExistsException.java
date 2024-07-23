package com.sangil_market.virtual.exceptions;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException() {
        super("Usuario ya existe");
    }
}
