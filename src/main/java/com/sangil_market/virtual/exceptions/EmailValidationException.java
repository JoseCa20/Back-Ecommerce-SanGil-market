package com.sangil_market.virtual.exceptions;

public class EmailValidationException extends RuntimeException{

    public EmailValidationException() {
        super("Formato de email incorrecto");
    }
}
