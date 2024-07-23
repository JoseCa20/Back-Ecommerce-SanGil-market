package com.sangil_market.virtual.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("Recurso no encontrado");
    }
}
