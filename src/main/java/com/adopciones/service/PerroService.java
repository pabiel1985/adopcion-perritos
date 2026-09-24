package com.adopciones.service;

import com.adopciones.dao.PerroDAO;
import com.adopciones.exceptions.PerroNoDisponibleException;
import com.adopciones.model.Perro;

import java.util.List;

public class PerroService {
    private final PerroDAO perroDAO;

    public PerroService(PerroDAO perroDAO) {
        this.perroDAO = perroDAO;
    }

    public void registrarPerro(Perro perro) {
        perroDAO.guardar(perro);
    }

    public List<Perro> listarTodos() {
        return perroDAO.listarTodos();
    }

    public Perro buscarPorId(int id) {
        return perroDAO.buscarPorId(id);
    }

    public void marcarComoAdoptado(int idPerro) throws PerroNoDisponibleException {
        Perro perro = perroDAO.buscarPorId(idPerro);
        if (perro == null) {
            throw new PerroNoDisponibleException("No existe un perro con ese identificador.");
        }
        if (!perro.puedeSerAdoptado()) {
            throw new PerroNoDisponibleException("El perro no está disponible para adopción.");
        }
        perro.adoptar();
        perroDAO.actualizarEstado(idPerro, perro.getEstado());
    }
}
