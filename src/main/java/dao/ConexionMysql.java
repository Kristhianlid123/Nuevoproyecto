package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql {

    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";
    private static final String BD = "biblioteca";
    private static final String IP = "localhost";
    private static final String PUERTO = "3306";

    private static final String URL =
            "jdbc:mysql://" + IP + ":" + PUERTO + "/" + BD
            + "?useSSL=false&serverTimezone=UTC";

    private Connection conexion;

    public Connection establecerConexion() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("URL: " + URL);
            System.out.println("Intentando conectar...");

            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            System.out.println("Conexión realizada correctamente.");

            

        } catch (ClassNotFoundException e) {

            System.out.println("No se encontró el Driver de MySQL.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();

        }

        return conexion;
    }

    public void cerrarConexion() {

        try {

            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            }

        } catch (SQLException e) {

            System.out.println("No fue posible cerrar la conexión.");
            e.printStackTrace();

        }

    }
}