package com.adopciones.model;

public class Administrador extends Usuario {
    private String permisos;

    public Administrador(int id, String nombre, String dni, String permisos) {
        super(id, nombre, dni, "Administrador");
        this.permisos = permisos;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }
}
