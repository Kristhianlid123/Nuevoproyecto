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

    public ArrayList<Libro> listarLibros() {

        ArrayList<Libro> listaLibros = new ArrayList<>();

        String consulta = "SELECT * FROM libros";

        try (

            Connection cn = new ConexionMysql().establecerConexion();
            PreparedStatement ps = cn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

        ) {

            while (rs.next()) {

                Libro libro = new Libro();

                libro.setId_libro(rs.getInt("id_libro"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setEstado(rs.getString("estado"));

                listaLibros.add(libro);

            }

        } catch (SQLException e) {

            System.out.println("Error al listar libros.");
            e.printStackTrace();

        }

        return listaLibros;

    }

}
