package com.adopciones.ui;

import com.adopciones.model.Adoptante;
import com.adopciones.model.Perro;
import com.adopciones.service.AdopcionService;
import com.adopciones.service.AdoptanteService;
import com.adopciones.service.PerroService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VistaPrincipal {
    private final PerroService perroService;
    private final AdoptanteService adoptanteService;
    private final AdopcionService adopcionService;
    private final Scanner scanner = new Scanner(System.in);

    public VistaPrincipal(PerroService perroService, AdoptanteService adoptanteService, AdopcionService adopcionService) {
        this.perroService = perroService;
        this.adoptanteService = adoptanteService;
        this.adopcionService = adopcionService;
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n=== Sistema de Adopción de Perros ===");
            System.out.println("1. Listar perros");
            System.out.println("2. Listar adoptantes");
            System.out.println("3. Registrar perro");
            System.out.println("4. Registrar adoptante");
            System.out.println("5. Registrar adopción");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> listarPerros();
                case 2 -> listarAdoptantes();
                case 3 -> registrarPerro();
                case 4 -> registrarAdoptante();
                case 5 -> registrarAdopcion();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void listarPerros() {
        List<Perro> perros = perroService.listarTodos();
        perros.forEach(p -> System.out.println(p.describir()));
    }

    private void listarAdoptantes() {
        List<Adoptante> adoptantes = adoptanteService.listarTodos();
        adoptantes.forEach(a -> System.out.println(a.getId() + " - " + a.getNombre() + " / DNI: " + a.getDni()));
    }

    private void registrarPerro() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Raza: ");
        String raza = scanner.nextLine();

        System.out.print("Porte: ");
        String porte = scanner.nextLine();

        System.out.print("Peso: ");
        double peso = Double.parseDouble(scanner.nextLine());

        System.out.print("Temperamento: ");
        String temperamento = scanner.nextLine();

        Perro perro = new Perro(id, nombre, edad, LocalDate.now(), raza, porte, peso, temperamento, "Disponible");
        perroService.registrarPerro(perro);
        System.out.println("Perro registrado correctamente.");
    }

    private void registrarAdoptante() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Domicilio: ");
        String domicilio = scanner.nextLine();

        Adoptante adoptante = new Adoptante(id, nombre, dni, telefono, email, domicilio);
        adoptanteService.registrarAdoptante(adoptante);
        System.out.println("Adoptante registrado correctamente.");
    }

    private void registrarAdopcion() {
        System.out.print("ID del perro: ");
        int idPerro = Integer.parseInt(scanner.nextLine());

        System.out.print("ID del adoptante: ");
        int idAdoptante = Integer.parseInt(scanner.nextLine());

        try {
            adopcionService.registrarAdopcion(idPerro, idAdoptante, LocalDate.now(), "Aceptada");
            System.out.println("Adopción registrada correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
