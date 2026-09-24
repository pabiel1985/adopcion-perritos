package com.adopciones.service;

import com.adopciones.dao.AdoptanteDAO;
import com.adopciones.exceptions.AdoptanteNoEncontradoException;
import com.adopciones.model.Adoptante;

import java.util.List;

public class AdoptanteService {
    private final AdoptanteDAO adoptanteDAO;

    public AdoptanteService(AdoptanteDAO adoptanteDAO) {
        this.adoptanteDAO = adoptanteDAO;
    }

    public void registrarAdoptante(Adoptante adoptante) {
        if (!adoptante.validarDatos()) {
            throw new IllegalArgumentException("Los datos del adoptante no son válidos.");
        }
        adoptanteDAO.guardar(adoptante);
    }

    public List<Adoptante> listarTodos() {
        return adoptanteDAO.listarTodos();
    }

    public Adoptante buscarPorId(int id) throws AdoptanteNoEncontradoException {
        Adoptante adoptante = adoptanteDAO.buscarPorId(id);
        if (adoptante == null) {
            throw new AdoptanteNoEncontradoException("No existe un adoptante con ese ID.");
        }
        return adoptante;
    }
}
