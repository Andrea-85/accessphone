/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accessphonemysql.controller;

import java.sql.Connection;
import accessphonemysql.dbConnection;
import accessphonemysql.model.Accesorio;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;

public class AccesorioController {

    // Método para insertar un accesorio
    public void insertarAccesorio(Accesorio acc) {
        String sql = "INSERT INTO accesorios(nombre, descripcion, precio) VALUES (?, ?, ?)";

        try (Connection conn = dbConnection.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, acc.getNombre());
            stmt.setString(2, acc.getDescripcion());
            stmt.setDouble(3, acc.getPrecio());

            stmt.executeUpdate();
            System.out.println("Accesorio insertado correctamente.");

        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
    
    // Método para consultar todos los accesorios
public void consultarAccesorios() {
    String sql = "SELECT * FROM accesorios";

    try (Connection conn = dbConnection.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        System.out.println("Lista de Accesorios:");
        System.out.println("---------------------");

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            double precio = rs.getDouble("precio");

            System.out.println("ID: " + id);
            System.out.println("Nombre: " + nombre);
            System.out.println("Descripción: " + descripcion);
            System.out.println("Precio: $" + precio);
            System.out.println("---------------------");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public void actualizarAccesorio(Accesorio accesorio) {
    String sql = "UPDATE accesorios SET nombre = ?, descripcion = ?, precio = ? WHERE id = ?";

    try (Connection conn = dbConnection.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, accesorio.getNombre());
        stmt.setString(2, accesorio.getDescripcion());
        stmt.setDouble(3, accesorio.getPrecio());
        stmt.setInt(4, accesorio.getId());

        int filasAfectadas = stmt.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Accesorio actualizado correctamente.");
        } else {
            System.out.println("No se encontró un accesorio con ese ID.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void eliminarAccesorio(int id) {
        String sql = "DELETE FROM accesorios WHERE id=?";

        try (Connection conn = dbConnection.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Accesorio eliminado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }    
    // Método para listar todos los accesorios
    public ArrayList<Accesorio> listarAccesorios() {
        ArrayList<Accesorio> lista = new ArrayList<>();
        String sql = "SELECT * FROM accesorios";

        try (Connection conn = dbConnection.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Accesorio acc = new Accesorio(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio")
                );
                lista.add(acc);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }

        return lista;
    }
}
    
    
