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
import modelos.Libro;

public class LibroDAO {

    public ArrayList<Libro> listarLibros(String buscar) {

        ArrayList<Libro> listaLibros = new ArrayList<>();

        String consulta = "SELECT * FROM libros WHERE titulo LIKE ? OR autor LIKE ?";

        try (
                Connection cn = new ConexionMysql().establecerConexion(); 
                PreparedStatement ps = cn.prepareStatement(consulta);
            ) {
            
            ps.setString(1, "%" + buscar + "%");
            ps.setString(2, "%" + buscar + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Libro libro = new Libro();

                libro.setId_libro(rs.getInt("id_libro"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setEstado(rs.getString("estado"));

                listaLibros.add(libro);

            }

            rs.close();

        } catch (SQLException e) {

            System.out.println("Error al buscar libros.");
            e.printStackTrace();

        }

        return listaLibros;

    }
    
    public boolean registrarLibro(Libro libro) {

        String consulta = "INSERT INTO libros(titulo, autor, estado) VALUES(?, ?, ?)";

        try (
                Connection cn = new ConexionMysql().establecerConexion(); PreparedStatement ps = cn.prepareStatement(consulta);) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getEstado());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al registrar el libro.");
            e.printStackTrace();

            return false;

        }

    }

}
