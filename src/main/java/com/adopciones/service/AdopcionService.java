package com.adopciones.service;

import com.adopciones.dao.AdopcionDAO;
import com.adopciones.dao.AdoptanteDAO;
import com.adopciones.dao.PerroDAO;
import com.adopciones.enums.EstadoPerro;
import com.adopciones.exceptions.AdopcionInvalidaException;
import com.adopciones.exceptions.AdoptanteNoEncontradoException;
import com.adopciones.exceptions.PerroNoDisponibleException;
import com.adopciones.model.Adopcion;

import java.time.LocalDate;
import java.util.List;

public class AdopcionService {
    private final AdopcionDAO adopcionDAO;
    private final PerroDAO perroDAO;
    private final AdoptanteDAO adoptanteDAO;

    public AdopcionService(AdopcionDAO adopcionDAO, PerroDAO perroDAO, AdoptanteDAO adoptanteDAO) {
        this.adopcionDAO = adopcionDAO;
        this.perroDAO = perroDAO;
        this.adoptanteDAO = adoptanteDAO;
    }

    public void registrarAdopcion(int idPerro, int idAdoptante, LocalDate fecha, String estado) {
        try {
            if (!perroDAO.existe(idPerro)) {
                throw new AdopcionInvalidaException("El perro indicado no existe.");
            }
            if (!adoptanteDAO.existe(idAdoptante)) {
                throw new AdoptanteNoEncontradoException("El adoptante indicado no existe.");
            }
            if (perroDAO.buscarPorId(idPerro).getEstado() != EstadoPerro.DISPONIBLE) {
                throw new PerroNoDisponibleException("El perro no está disponible para adopción.");
            }

            int id = adopcionDAO.listarTodos().size() + 1;
            Adopcion adopcion = new Adopcion(id, idPerro, idAdoptante, fecha, estado, "Adopción registrada correctamente");
            adopcionDAO.guardar(adopcion);
            perroDAO.actualizarEstado(idPerro, EstadoPerro.ADOPTADO);
        } catch (AdopcionInvalidaException | AdoptanteNoEncontradoException | PerroNoDisponibleException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public List<Adopcion> listarAdopciones() {
        return adopcionDAO.listarTodos();
    }
}
