package com.softtek.m2.modelo;

import java.util.Objects;

public class Tarea {

    // Contador estático para generar identificadores únicos.
    private static Integer contador = 0;

    // Identificador de la tarea.
    private Integer id;

    // Descripción de la tarea.
    private String descripcion;

    public Tarea(String descripcion) {
        this.id = ++contador;
        this.descripcion = descripcion;
    }

    // Getters, Setters, equals, hashCode y toString
    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return Objects.equals(id, tarea.id) && Objects.equals(descripcion, tarea.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
