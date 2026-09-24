package com.adopciones.dao;

import com.adopciones.model.Adopcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdopcionDAO {
    public void guardar(Adopcion adopcion) {
        String sql = "INSERT INTO adopciones (id, id_perro, id_adoptante, fecha, estado, observaciones) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, adopcion.getId());
            ps.setInt(2, adopcion.getIdPerro());
            ps.setInt(3, adopcion.getIdAdoptante());
            ps.setDate(4, java.sql.Date.valueOf(adopcion.getFecha()));
            ps.setString(5, adopcion.getEstado());
            ps.setString(6, adopcion.getObservaciones());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar adopción", e);
        }
    }

    public List<Adopcion> listarTodos() {
        List<Adopcion> adopciones = new ArrayList<>();
        String sql = "SELECT * FROM adopciones";

        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                adopciones.add(new Adopcion(
                        rs.getInt("id"),
                        rs.getInt("id_perro"),
                        rs.getInt("id_adoptante"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getString("estado"),
                        rs.getString("observaciones")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar adopciones", e);
        }

        return adopciones;
    }
}
