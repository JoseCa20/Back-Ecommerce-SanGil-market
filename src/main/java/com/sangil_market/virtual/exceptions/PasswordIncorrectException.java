package com.sangil_market.virtual.exceptions;

public class PasswordIncorrectException extends RuntimeException{

    public PasswordIncorrectException(){
        super("Contraseña incorrecta");
    }
}
