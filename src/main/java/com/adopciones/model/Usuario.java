package com.adopciones.model;

import com.adopciones.enums.TipoUsuario;

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String dni;
    protected TipoUsuario tipoUsuario;

    public Usuario(int id, String nombre, String dni, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getRol() {
        return tipoUsuario.name();
    }
}
