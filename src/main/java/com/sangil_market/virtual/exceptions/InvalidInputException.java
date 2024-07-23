package com.sangil_market.virtual.exceptions;

public class InvalidInputException extends RuntimeException{

    public InvalidInputException() {
        super("Campo inválido");
    }
}
