package com.adopciones.model;

import java.time.LocalDate;

public class Adopcion {
    private int id;
    private int idPerro;
    private int idAdoptante;
    private LocalDate fecha;
    private String estado;
    private String observaciones;

    public Adopcion(int id, int idPerro, int idAdoptante, LocalDate fecha, String estado, String observaciones) {
        this.id = id;
        this.idPerro = idPerro;
        this.idAdoptante = idAdoptante;
        this.fecha = fecha;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public int getIdPerro() {
        return idPerro;
    }

    public int getIdAdoptante() {
        return idAdoptante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
