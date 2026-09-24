package com.adopciones.model;

import com.adopciones.interfaces.Adoptable;

import java.time.LocalDate;

public class Perro extends Animal implements Adoptable {
    private String raza;
    private String porte;
    private double peso;
    private String temperamento;
    private String estado;

    public Perro(int id, String nombre, int edad, LocalDate fechaRescate,
                 String raza, String porte, double peso,
                 String temperamento, String estado) {
        super(id, nombre, edad, fechaRescate);
        this.raza = raza;
        this.porte = porte;
        this.peso = peso;
        this.temperamento = temperamento;
        this.estado = estado;
    }

    @Override
    public boolean puedeSerAdoptado() {
        return "Disponible".equalsIgnoreCase(estado);
    }

    @Override
    public void adoptar() {
        this.estado = "Adoptado";
    }

    @Override
    public void marcarComoNoDisponible() {
        this.estado = "No disponible";
    }

    @Override
    public String describir() {
        return "Perro: " + getNombre() +
                " | Raza: " + raza +
                " | Edad: " + getEdad() +
                " | Estado: " + estado;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
