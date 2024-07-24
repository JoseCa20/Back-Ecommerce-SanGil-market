package com.sangil_market.virtual.exceptions;

public class TokenValidationException extends RuntimeException{
    public TokenValidationException(){
        super("Validación del token falló");
    }
}
