package com.adopciones.model;

import java.time.LocalDate;

public class Solicitud {
    private int id;
    private int idPerro;
    private int idAdoptante;
    private LocalDate fecha;
    private String estado;
    private String motivoRechazo;

    public Solicitud(int id, int idPerro, int idAdoptante, LocalDate fecha, String estado, String motivoRechazo) {
        this.id = id;
        this.idPerro = idPerro;
        this.idAdoptante = idAdoptante;
        this.fecha = fecha;
        this.estado = estado;
        this.motivoRechazo = motivoRechazo;
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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }
}
