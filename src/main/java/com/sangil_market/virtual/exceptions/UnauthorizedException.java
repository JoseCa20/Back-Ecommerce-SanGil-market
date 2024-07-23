package com.sangil_market.virtual.exceptions;

public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException(){
        super("No autorizado!");
    }
}
