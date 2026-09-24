package com.adopciones.genericos;

import java.util.ArrayList;
import java.util.List;

public class Repositorio<T> {
    private final List<T> elementos = new ArrayList<>();

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public void eliminar(T elemento) {
        elementos.remove(elemento);
    }

    public List<T> listarTodos() {
        return new ArrayList<>(elementos);
    }

    public boolean contiene(T elemento) {
        return elementos.contains(elemento);
    }
}
