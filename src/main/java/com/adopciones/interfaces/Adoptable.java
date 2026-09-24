package com.adopciones.interfaces;

public interface Adoptable {
    boolean puedeSerAdoptado();
    void adoptar();
    void marcarComoNoDisponible();
}
