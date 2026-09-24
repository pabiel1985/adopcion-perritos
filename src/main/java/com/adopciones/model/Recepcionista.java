package com.adopciones.model;

import com.adopciones.enums.TipoUsuario;

public class Recepcionista extends Usuario {
    private String sector;

    public Recepcionista(int id, String nombre, String dni, String sector) {
        super(id, nombre, dni, TipoUsuario.RECEPCIONISTA);
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
