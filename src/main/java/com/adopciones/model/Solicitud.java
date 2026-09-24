package com.adopciones.model;

import com.adopciones.enums.EstadoSolicitud;

import java.time.LocalDate;

public class Solicitud {
    private int id;
    private int idPerro;
    private int idAdoptante;
    private LocalDate fecha;
    private EstadoSolicitud estado;
    private String motivoRechazo;

    public Solicitud(int id, int idPerro, int idAdoptante, LocalDate fecha, EstadoSolicitud estado, String motivoRechazo) {
        this.id = id;
        this.idPerro = idPerro;
        this.idAdoptante = idAdoptante;
        this.fecha = fecha;
        this.estado = estado;
        this.motivoRechazo = motivoRechazo;
    }

    public Solicitud(int id, int idPerro, int idAdoptante, LocalDate fecha, String estado, String motivoRechazo) {
        this(id, idPerro, idAdoptante, fecha, EstadoSolicitud.valueOf(estado.toUpperCase().replace(' ', '_')), motivoRechazo);
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

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }
}
