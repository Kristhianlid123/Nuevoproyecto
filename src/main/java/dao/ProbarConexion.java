/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class ProbarConexion {
    public static void main(String[] args) {
        ConexionMysql conexionBD = new ConexionMysql();
        Connection conexion;
        conexion = conexionBD.establecerConexion();
        
        if(conexion!=null){
            System.out.println("La conexion fue establecida correctamente");
            
        }else{
            System.out.println("No fue posible conectar con la BD");
        }
        conexionBD.cerrarConexion();
        System.out.println("Programa finalizado");
    }
}
