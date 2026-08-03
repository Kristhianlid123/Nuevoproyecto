/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Prestamo;

public class PrestamoDAO {

    public boolean registrarPrestamo(Prestamo prestamo) {

        String consulta = "INSERT INTO prestamos "
                + "(id_lector, id_libro, fecha_prestamo, fecha_devolucion, estado) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (
                Connection cn = new ConexionMysql().establecerConexion();
                PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setInt(1, prestamo.getId_lector());
            ps.setInt(2, prestamo.getId_libro());
            ps.setDate(3, prestamo.getFecha_prestamo());
            ps.setDate(4, prestamo.getFecha_devolucion());
            ps.setString(5, prestamo.getEstado());

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {

            System.out.println("Error al registrar préstamo.");
            e.printStackTrace();

        }

        return false;

    }

}
