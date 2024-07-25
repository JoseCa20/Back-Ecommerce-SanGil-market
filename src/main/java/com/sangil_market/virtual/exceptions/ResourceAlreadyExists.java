package com.sangil_market.virtual.exceptions;

public class ResourceAlreadyExists extends RuntimeException{

    public ResourceAlreadyExists(){
        super("Recurso ya existe");
    }
}
