package com.adopciones.model;

public class Adoptante {
    private int id;
    private String nombre;
    private String dni;
    private String telefono;
    private String email;
    private String domicilio;

    public Adoptante(int id, String nombre, String dni, String telefono, String email, String domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.domicilio = domicilio;
    }

    public boolean validarDatos() {
        return nombre != null && !nombre.isBlank()
                && dni != null && !dni.isBlank()
                && email != null && email.contains("@");
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
