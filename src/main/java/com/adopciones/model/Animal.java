package com.adopciones.model;

import java.time.LocalDate;

public abstract class Animal {
    private int id;
    private String nombre;
    private int edad;
    private LocalDate fechaRescate;

    protected Animal(int id, String nombre, int edad, LocalDate fechaRescate) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.fechaRescate = fechaRescate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaRescate() {
        return fechaRescate;
    }

    public void setFechaRescate(LocalDate fechaRescate) {
        this.fechaRescate = fechaRescate;
    }

    public abstract boolean puedeSerAdoptado();
    public abstract void adoptar();
    public abstract String describir();
}
