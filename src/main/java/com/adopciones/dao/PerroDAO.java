package com.adopciones.dao;

import com.adopciones.model.Perro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PerroDAO {
    public void guardar(Perro perro) {
        String sql = "INSERT INTO perros (id, nombre, edad, fecha_rescate, raza, porte, peso, temperamento, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, perro.getId());
            ps.setString(2, perro.getNombre());
            ps.setInt(3, perro.getEdad());
            ps.setDate(4, java.sql.Date.valueOf(perro.getFechaRescate()));
            ps.setString(5, perro.getRaza());
            ps.setString(6, perro.getPorte());
            ps.setDouble(7, perro.getPeso());
            ps.setString(8, perro.getTemperamento());
            ps.setString(9, perro.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar perro", e);
        }
    }

    public List<Perro> listarTodos() {
        List<Perro> perros = new ArrayList<>();
        String sql = "SELECT * FROM perros";

        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                perros.add(new Perro(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getDate("fecha_rescate").toLocalDate(),
                        rs.getString("raza"),
                        rs.getString("porte"),
                        rs.getDouble("peso"),
                        rs.getString("temperamento"),
                        rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar perros", e);
        }

        return perros;
    }

    public Perro buscarPorId(int id) {
        String sql = "SELECT * FROM perros WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Perro(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getDate("fecha_rescate").toLocalDate(),
                        rs.getString("raza"),
                        rs.getString("porte"),
                        rs.getDouble("peso"),
                        rs.getString("temperamento"),
                        rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar perro", e);
        }

        return null;
    }

    public void actualizarEstado(int idPerro, String estado) {
        String sql = "UPDATE perros SET estado = ? WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, estado);
            ps.setInt(2, idPerro);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar perro", e);
        }
    }

    public boolean existe(int idPerro) {
        String sql = "SELECT COUNT(*) FROM perros WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPerro);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al comprobar perro", e);
        }
        return false;
    }
}
