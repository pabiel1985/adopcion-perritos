package com.adopciones.dao;

import com.adopciones.model.Adoptante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdoptanteDAO {
    public void guardar(Adoptante adoptante) {
        String sql = "INSERT INTO adoptantes (id, nombre, dni, telefono, email, domicilio) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, adoptante.getId());
            ps.setString(2, adoptante.getNombre());
            ps.setString(3, adoptante.getDni());
            ps.setString(4, adoptante.getTelefono());
            ps.setString(5, adoptante.getEmail());
            ps.setString(6, adoptante.getDomicilio());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar adoptante", e);
        }
    }

    public List<Adoptante> listarTodos() {
        List<Adoptante> adoptantes = new ArrayList<>();
        String sql = "SELECT * FROM adoptantes";

        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                adoptantes.add(new Adoptante(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("domicilio")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar adoptantes", e);
        }

        return adoptantes;
    }

    public Adoptante buscarPorId(int id) {
        String sql = "SELECT * FROM adoptantes WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Adoptante(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("domicilio")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar adoptante", e);
        }

        return null;
    }

    public boolean existe(int idAdoptante) {
        String sql = "SELECT COUNT(*) FROM adoptantes WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAdoptante);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al comprobar adoptante", e);
        }
        return false;
    }
}
