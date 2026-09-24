package com.adopciones;

import com.adopciones.dao.AdopcionDAO;
import com.adopciones.dao.AdoptanteDAO;
import com.adopciones.dao.ConexionDB;
import com.adopciones.dao.PerroDAO;
import com.adopciones.enums.EstadoPerro;
import com.adopciones.model.Administrador;
import com.adopciones.model.Adoptante;
import com.adopciones.model.Perro;
import com.adopciones.model.Recepcionista;
import com.adopciones.service.AdopcionService;
import com.adopciones.service.AdoptanteService;
import com.adopciones.service.PerroService;
import com.adopciones.ui.VistaPrincipal;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ConexionDB.inicializar();

        PerroDAO perroDAO = new PerroDAO();
        AdoptanteDAO adoptanteDAO = new AdoptanteDAO();
        AdopcionDAO adopcionDAO = new AdopcionDAO();

        PerroService perroService = new PerroService(perroDAO);
        AdoptanteService adoptanteService = new AdoptanteService(adoptanteDAO);
        AdopcionService adopcionService = new AdopcionService(adopcionDAO, perroDAO, adoptanteDAO);

        cargarDatosIniciales(perroService, adoptanteService);

        Administrador administrador = new Administrador(100, "Carla Mesa", "30111222", "Alta de usuarios, backups, permisos");
        Recepcionista recepcionista = new Recepcionista(101, "Bruno Díaz", "28111222", "Front Desk");

        System.out.println("Usuario activo: " + administrador.getRol() + " - " + administrador.getNombre());
        System.out.println("Usuario activo: " + recepcionista.getRol() + " - " + recepcionista.getNombre());

        VistaPrincipal vista = new VistaPrincipal(perroService, adoptanteService, adopcionService);
        vista.mostrarMenu();
    }

    private static void cargarDatosIniciales(PerroService perroService, AdoptanteService adoptanteService) {
        if (!perroService.listarTodos().isEmpty()) {
            return;
        }

        perroService.registrarPerro(new Perro(
                1, "Luna", 2, LocalDate.of(2024, 1, 15),
                "Labrador", "Mediano", 25.0, "Sociable", EstadoPerro.DISPONIBLE
        ));

        perroService.registrarPerro(new Perro(
                2, "Max", 4, LocalDate.of(2023, 6, 10),
                "Pastor Alemán", "Grande", 30.0, "Protector", EstadoPerro.DISPONIBLE
        ));

        adoptanteService.registrarAdoptante(new Adoptante(
                1, "Ana García", "30123456", "1122334455",
                "ana@test.com", "Calle 123"
        ));
    }
}
