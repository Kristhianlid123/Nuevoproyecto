/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Lector;

public class LectorDAO {

    public ArrayList<Lector> listarLectores(String buscar, String filtro) {

        ArrayList<Lector> listaLectores = new ArrayList<>();

        String consulta = "";

        if (filtro.equals("activos")) {

            consulta = "SELECT * FROM lectores WHERE activo = 1 AND (documento LIKE ? OR nombre LIKE ?)";

        } else if (filtro.equals("retirados")) {

            consulta = "SELECT * FROM lectores WHERE activo = 0 AND (documento LIKE ? OR nombre LIKE ?)";

        } else {

            consulta = "SELECT * FROM lectores WHERE documento LIKE ? OR nombre LIKE ?";

        }

        try (
                Connection cn = new ConexionMysql().establecerConexion();
                PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setString(1, "%" + buscar + "%");
            ps.setString(2, "%" + buscar + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Lector lector = new Lector();

                lector.setId_lector(rs.getInt("id_lector"));
                lector.setDocumento(rs.getString("documento"));
                lector.setNombre(rs.getString("nombre"));
                lector.setTelefono(rs.getString("telefono"));
                lector.setCorreo(rs.getString("correo"));
                lector.setDireccion(rs.getString("direccion"));
                lector.setActivo(rs.getBoolean("activo"));

                listaLectores.add(lector);

            }

            rs.close();

        } catch (SQLException e) {

            System.out.println("Error al listar lectores.");
            e.printStackTrace();

        }

        return listaLectores;

    }

    public boolean registrarLector(Lector lector) {

        String consulta = "INSERT INTO lectores (documento, nombre, telefono, correo, direccion, activo) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection cn = new ConexionMysql().establecerConexion();
                PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setString(1, lector.getDocumento());
            ps.setString(2, lector.getNombre());
            ps.setString(3, lector.getTelefono());
            ps.setString(4, lector.getCorreo());
            ps.setString(5, lector.getDireccion());
            ps.setBoolean(6, true);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al registrar el lector.");
            e.printStackTrace();

            return false;

        }

    }

    public boolean existeLector(String documento) {

        String consulta = "SELECT * FROM lectores WHERE documento = ?";

        try (
                Connection cn = new ConexionMysql().establecerConexion();
                PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setString(1, documento);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {

            System.out.println("Error al verificar el lector.");
            e.printStackTrace();

        }

        return false;

    }

    public Lector obtenerLector(int id) {

        Lector lector = null;

        String consulta = "SELECT * FROM lectores WHERE id_lector = ?";

        try (
                Connection cn = new ConexionMysql().establecerConexion();
                PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                lector = new Lector();

                lector.setId_lector(rs.getInt("id_lector"));
                lector.setDocumento(rs.getString("documento"));
                lector.setNombre(rs.getString("nombre"));
                lector.setTelefono(rs.getString("telefono"));
                lector.setCorreo(rs.getString("correo"));
                lector.setDireccion(rs.getString("direccion"));
                lector.setActivo(rs.getBoolean("activo"));

            }

            rs.close();

        } catch (SQLException e) {

            System.out.println("Error al obtener el lector.");
            e.printStackTrace();

        }

        return lector;

    }

    public boolean actualizarLector(Lector lector) {

        String consulta = "UPDATE lectores SET documento = ?, nombre = ?, telefono = ?, correo = ?, direccion = ? WHERE id_lector = ?";

        try (
                Connection cn = new ConexionMysql().establecerConexion();
                PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setString(1, lector.getDocumento());
            ps.setString(2, lector.getNombre());
            ps.setString(3, lector.getTelefono());
            ps.setString(4, lector.getCorreo());
            ps.setString(5, lector.getDireccion());
            ps.setInt(6, lector.getId_lector());

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {

            System.out.println("Error al actualizar el lector.");
            e.printStackTrace();

        }

        return false;

    }

    public boolean retirarLector(int id) {

        String consulta = "UPDATE lectores SET activo = 0 WHERE id_lector = ?";

        try (
                Connection cn = new ConexionMysql().establecerConexion();
                PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {

            System.out.println("Error al retirar el lector.");
            e.printStackTrace();

        }

        return false;

    }

    public boolean reincorporarLector(int id) {

        String consulta = "UPDATE lectores SET activo = 1 WHERE id_lector = ?";

        try (
                Connection cn = new ConexionMysql().establecerConexion();
                PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {

            System.out.println("Error al reincorporar el lector.");
            e.printStackTrace();

        }

        return false;

    }
    
    public Lector buscarPorDocumento(String documento) {

        Lector lector = null;

        String consulta = "SELECT * FROM lectores WHERE documento = ? AND activo = 1";

        try (
                Connection cn = new ConexionMysql().establecerConexion(); PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setString(1, documento);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                lector = new Lector();

                lector.setId_lector(rs.getInt("id_lector"));
                lector.setDocumento(rs.getString("documento"));
                lector.setNombre(rs.getString("nombre"));
                lector.setTelefono(rs.getString("telefono"));
                lector.setCorreo(rs.getString("correo"));
                lector.setDireccion(rs.getString("direccion"));
                lector.setActivo(rs.getBoolean("activo"));

            }

            rs.close();

        } catch (SQLException e) {

            System.out.println("Error al buscar lector.");
            e.printStackTrace();

        }

        return lector;

    }

}
