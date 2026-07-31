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

        String consultaPrestamo
                = "INSERT INTO prestamos (id_lector, id_libro, fecha_prestamo, fecha_devolucion, estado) "
                + "VALUES (?, ?, ?, ?, ?)";

        String consultaLibro
                = "UPDATE libros SET estado = 'Prestado' WHERE id_libro = ?";

        try (
                Connection cn = new ConexionMysql().establecerConexion()) {

            cn.setAutoCommit(false);

            PreparedStatement psPrestamo = cn.prepareStatement(consultaPrestamo);

            psPrestamo.setInt(1, prestamo.getId_lector());
            psPrestamo.setInt(2, prestamo.getId_libro());
            psPrestamo.setDate(3, prestamo.getFecha_prestamo());
            psPrestamo.setDate(4, prestamo.getFecha_devolucion());
            psPrestamo.setString(5, prestamo.getEstado());

            psPrestamo.executeUpdate();

            PreparedStatement psLibro = cn.prepareStatement(consultaLibro);

            psLibro.setInt(1, prestamo.getId_libro());

            psLibro.executeUpdate();

            cn.commit();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;

        }

    }
}
