package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Usuario;

public class UsuarioDAO {

    // Método para validar el inicio de sesión
    public Usuario validarLogin(String usuario, String contraseña) {

        System.out.println("Entró a validarLogin");

        Usuario usuarioEncontrado = null;

        String consulta = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";

        try (
                Connection cn = new ConexionMysql().establecerConexion();
                PreparedStatement ps = cn.prepareStatement(consulta);
        ) {

            ps.setString(1, usuario);
            ps.setString(2, contraseña);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                usuarioEncontrado = new Usuario();

                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setUsuario(rs.getString("usuario"));
                usuarioEncontrado.setContraseña(rs.getString("contraseña"));
                usuarioEncontrado.setNombre(rs.getString("nombre"));
                usuarioEncontrado.setRol(rs.getString("rol"));

                System.out.println("Usuario encontrado: " + usuarioEncontrado.getUsuario());

            } else {

                System.out.println("No encontró usuario");

            }

            rs.close();

        } catch (SQLException e) {

            System.out.println("Error al validar el usuario: " + e.getMessage());
            e.printStackTrace();

        }

        return usuarioEncontrado;

    }

}