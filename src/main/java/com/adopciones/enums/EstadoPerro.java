package com.adopciones.enums;

public enum EstadoPerro {
    DISPONIBLE,
    ADOPTADO,
    NO_DISPONIBLE;

    public boolean puedeSerAdoptado() {
        return this == DISPONIBLE;
    }
}
