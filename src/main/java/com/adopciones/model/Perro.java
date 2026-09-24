package com.adopciones.model;

import com.adopciones.enums.EstadoPerro;
import com.adopciones.interfaces.Adoptable;

import java.time.LocalDate;

public class Perro extends Animal implements Adoptable {
    private String raza;
    private String porte;
    private double peso;
    private String temperamento;
    private EstadoPerro estado;

    public Perro(int id, String nombre, int edad, LocalDate fechaRescate,
                 String raza, String porte, double peso,
                 String temperamento, EstadoPerro estado) {
        super(id, nombre, edad, fechaRescate);
        this.raza = raza;
        this.porte = porte;
        this.peso = peso;
        this.temperamento = temperamento;
        this.estado = estado;
    }

    public Perro(int id, String nombre, int edad, LocalDate fechaRescate,
                 String raza, String porte, double peso,
                 String temperamento, String estado) {
        this(id, nombre, edad, fechaRescate, raza, porte, peso, temperamento,
                EstadoPerro.valueOf(estado.toUpperCase().replace(' ', '_')));
    }

    @Override
    public boolean puedeSerAdoptado() {
        return estado.puedeSerAdoptado();
    }

    @Override
    public void adoptar() {
        this.estado = EstadoPerro.ADOPTADO;
    }

    @Override
    public void marcarComoNoDisponible() {
        this.estado = EstadoPerro.NO_DISPONIBLE;
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

    public EstadoPerro getEstado() {
        return estado;
    }

    public void setEstado(EstadoPerro estado) {
        this.estado = estado;
    }
}
