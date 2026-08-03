/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Prestamo;
import java.util.ArrayList;
import java.sql.ResultSet;

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
    
    public ArrayList<Prestamo> listarPrestamosActivos(int idLector) {

        ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

        String consulta = "SELECT * FROM prestamos "
                + "WHERE id_lector = ? "
                + "AND estado = 'Prestado'";

        try (
                Connection cn = new ConexionMysql().establecerConexion(); PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setInt(1, idLector);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Prestamo prestamo = new Prestamo();

                prestamo.setId_prestamo(rs.getInt("id_prestamo"));
                prestamo.setId_libro(rs.getInt("id_libro"));
                prestamo.setId_lector(rs.getInt("id_lector"));
                prestamo.setFecha_prestamo(rs.getDate("fecha_prestamo"));
                prestamo.setFecha_devolucion(rs.getDate("fecha_devolucion"));
                prestamo.setEstado(rs.getString("estado"));

                listaPrestamos.add(prestamo);

            }

            rs.close();

        } catch (SQLException e) {

            System.out.println("Error al listar préstamos.");
            e.printStackTrace();

        }

        return listaPrestamos;

    }
    
    public boolean devolverPrestamo(int idPrestamo) {

        String consulta = "UPDATE prestamos "
                + "SET estado = 'Devuelto' "
                + "WHERE id_prestamo = ?";

        try (
                Connection cn = new ConexionMysql().establecerConexion(); PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setInt(1, idPrestamo);

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {

            System.out.println("Error al devolver préstamo.");
            e.printStackTrace();

        }

        return false;

    }
    
    public int obtenerIdLibro(int idPrestamo) {

        String consulta = "SELECT id_libro FROM prestamos WHERE id_prestamo = ?";

        try (
                Connection cn = new ConexionMysql().establecerConexion(); PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setInt(1, idPrestamo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt("id_libro");

            }

        } catch (SQLException e) {

            System.out.println("Error al obtener libro del préstamo.");
            e.printStackTrace();

        }

        return 0;

    }

}
