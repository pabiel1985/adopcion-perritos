package com.adopciones.model;

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String dni;
    protected String rol;

    public Usuario(int id, String nombre, String dni, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.rol = rol;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
