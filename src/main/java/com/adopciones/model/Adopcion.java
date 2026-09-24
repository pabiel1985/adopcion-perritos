package com.adopciones.model;

import com.adopciones.enums.EstadoAdopcion;

import java.time.LocalDate;

public class Adopcion {
    private int id;
    private int idPerro;
    private int idAdoptante;
    private LocalDate fecha;
    private EstadoAdopcion estado;
    private String observaciones;

    public Adopcion(int id, int idPerro, int idAdoptante, LocalDate fecha, EstadoAdopcion estado, String observaciones) {
        this.id = id;
        this.idPerro = idPerro;
        this.idAdoptante = idAdoptante;
        this.fecha = fecha;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public Adopcion(int id, int idPerro, int idAdoptante, LocalDate fecha, String estado, String observaciones) {
        this(id, idPerro, idAdoptante, fecha, EstadoAdopcion.valueOf(estado.toUpperCase().replace(' ', '_')), observaciones);
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

    public EstadoAdopcion getEstado() {
        return estado;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
