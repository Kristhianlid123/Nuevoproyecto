/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.sql.Date;

public class Prestamo {

    private int id_prestamo;
    private int id_lector;
    private int id_libro;
    private Date fecha_prestamo;
    private Date fecha_devolucion;
    private Date fecha_devolucion_real;
    private String estado;

    public Prestamo() {
    }

    public Prestamo(int id_prestamo, int id_lector, int id_libro,
            Date fecha_prestamo, Date fecha_devolucion,
            Date fecha_devolucion_real, String estado) {

        this.id_prestamo = id_prestamo;
        this.id_lector = id_lector;
        this.id_libro = id_libro;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.fecha_devolucion_real = fecha_devolucion_real;
        this.estado = estado;

    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_lector() {
        return id_lector;
    }

    public void setId_lector(int id_lector) {
        this.id_lector = id_lector;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public Date getFecha_devolucion_real() {
        return fecha_devolucion_real;
    }

    public void setFecha_devolucion_real(Date fecha_devolucion_real) {
        this.fecha_devolucion_real = fecha_devolucion_real;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
