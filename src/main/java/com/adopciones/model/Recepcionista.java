package com.adopciones.model;

public class Recepcionista extends Usuario {
    private String sector;

    public Recepcionista(int id, String nombre, String dni, String sector) {
        super(id, nombre, dni, "Recepcionista");
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
