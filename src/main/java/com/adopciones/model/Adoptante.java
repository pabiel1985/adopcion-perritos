package com.adopciones.model;

public class Adoptante extends Usuario {
    private String telefono;
    private String email;
    private String domicilio;

    public Adoptante(int id, String nombre, String dni, String telefono, String email, String domicilio) {
        super(id, nombre, dni, "Adoptante");
        this.telefono = telefono;
        this.email = email;
        this.domicilio = domicilio;
    }

    public boolean validarDatos() {
        return nombre != null && !nombre.isBlank()
                && dni != null && !dni.isBlank()
                && email != null && email.contains("@");
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
