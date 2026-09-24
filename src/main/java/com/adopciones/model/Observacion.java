package com.adopciones.model;

import java.time.LocalDate;

public class Observacion {
    private int id;
    private int idAdopcion;
    private LocalDate fecha;
    private String descripcion;

    public Observacion(int id, int idAdopcion, LocalDate fecha, String descripcion) {
        this.id = id;
        this.idAdopcion = idAdopcion;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public int getIdAdopcion() {
        return idAdopcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
