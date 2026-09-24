package com.adopciones.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:h2:mem:adopciones_db;DB_CLOSE_DELAY=-1;MODE=MySQL";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void inicializar() {
        try (Connection conn = getConnection();
             java.sql.Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS perros (" +
                    "id INT PRIMARY KEY, nombre VARCHAR(100), edad INT, fecha_rescate DATE, " +
                    "raza VARCHAR(100), porte VARCHAR(50), peso DOUBLE, temperamento VARCHAR(150), estado VARCHAR(50));");

            stmt.execute("CREATE TABLE IF NOT EXISTS adoptantes (" +
                    "id INT PRIMARY KEY, nombre VARCHAR(100), dni VARCHAR(20), telefono VARCHAR(30), " +
                    "email VARCHAR(100), domicilio VARCHAR(200));");

            stmt.execute("CREATE TABLE IF NOT EXISTS adopciones (" +
                    "id INT PRIMARY KEY, id_perro INT, id_adoptante INT, fecha DATE, estado VARCHAR(50), observaciones VARCHAR(255));");

            stmt.execute("CREATE TABLE IF NOT EXISTS solicitudes (" +
                    "id INT PRIMARY KEY, id_perro INT, id_adoptante INT, fecha DATE, estado VARCHAR(50), motivo_rechazo VARCHAR(255));");

            stmt.execute("CREATE TABLE IF NOT EXISTS observaciones (" +
                    "id INT PRIMARY KEY, id_adopcion INT, fecha DATE, descripcion VARCHAR(255));");
        } catch (SQLException e) {
            throw new RuntimeException("Error al inicializar la base de datos", e);
        }
    }
}
