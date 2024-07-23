package com.sangil_market.virtual.exceptions;

public class OperationNotAllowedException extends RuntimeException{

    public OperationNotAllowedException() {
        super("Operación no permitida");
    }
}
