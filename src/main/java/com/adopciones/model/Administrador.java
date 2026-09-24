package com.adopciones.model;

import com.adopciones.enums.TipoUsuario;

public class Administrador extends Usuario {
    private String permisos;

    public Administrador(int id, String nombre, String dni, String permisos) {
        super(id, nombre, dni, TipoUsuario.ADMINISTRADOR);
        this.permisos = permisos;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }
}
