package com.softtek.m2.excepciones;

public class DatosInvalidosException extends RuntimeException{
    public DatosInvalidosException(String mensaje){
        super(mensaje);
    }
}
