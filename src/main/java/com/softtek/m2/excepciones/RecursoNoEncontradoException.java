package com.softtek.m2.excepciones;

public class RecursoNoEncontradoException extends RuntimeException{
    public RecursoNoEncontradoException (String mensaje){
        super(mensaje);
    }
}
