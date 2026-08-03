/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.LibroDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Libro;
import dao.LectorDAO;
import dao.PrestamoDAO;
import modelos.Lector;
import modelos.Prestamo;
import java.sql.Date;

@WebServlet(name = "SvPrestamos", urlPatterns = {"/SvPrestamos"})
public class SvPrestamos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LibroDAO dao = new LibroDAO();

        ArrayList<Libro> listaLibros = dao.listarLibrosDisponibles("");

        request.setAttribute("buscar", "");
        request.setAttribute("listaLibros", listaLibros);
        
        String mensaje = request.getParameter("mensaje");
        request.setAttribute("mensaje", mensaje);

        request.getRequestDispatcher("prestamos.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("buscar".equals(accion)) {

            String buscar = request.getParameter("buscar");

            if (buscar == null) {
                buscar = "";
            }

            LibroDAO dao = new LibroDAO();

            ArrayList<Libro> listaLibros = dao.listarLibrosDisponibles(buscar);

            request.setAttribute("buscar", buscar);
            request.setAttribute("listaLibros", listaLibros);

            request.getRequestDispatcher("prestamos.jsp").forward(request, response);

        } else if ("registrar".equals(accion)) {

            String documento = request.getParameter("documento");
            String idLibro = request.getParameter("idLibro");
            String fechaPrestamo = request.getParameter("fechaPrestamo");
            String fechaDevolucion = request.getParameter("fechaDevolucion");
            
            if (documento == null || documento.trim().isEmpty()
                    || idLibro == null
                    || fechaPrestamo == null || fechaPrestamo.isEmpty()
                    || fechaDevolucion == null || fechaDevolucion.isEmpty()) {

                request.setAttribute("mensaje", "Debe completar todos los campos.");

                LibroDAO dao = new LibroDAO();

                request.setAttribute("buscar", "");
                request.setAttribute("listaLibros", dao.listarLibrosDisponibles(""));

                request.getRequestDispatcher("prestamos.jsp").forward(request, response);
                return;

            }
            
            Date fechaP = Date.valueOf(fechaPrestamo);
            Date fechaD = Date.valueOf(fechaDevolucion);

            if (fechaD.before(fechaP)) {

                request.setAttribute("mensaje",
                        "La fecha de devolución no puede ser anterior a la fecha del préstamo.");

                LibroDAO dao = new LibroDAO();

                request.setAttribute("buscar", "");
                request.setAttribute("listaLibros", dao.listarLibrosDisponibles(""));

                request.getRequestDispatcher("prestamos.jsp").forward(request, response);
                return;

            }

                
          
            LectorDAO lectorDAO = new LectorDAO();
            Lector lector = lectorDAO.buscarPorDocumento(documento);

            if (lector == null) {

                request.setAttribute("mensaje", "El lector no existe.");

                LibroDAO dao = new LibroDAO();
                request.setAttribute("buscar", "");
                request.setAttribute("listaLibros", dao.listarLibrosDisponibles(""));

                request.getRequestDispatcher("prestamos.jsp").forward(request, response);
                return;

            }

            Prestamo prestamo = new Prestamo();

            prestamo.setId_lector(lector.getId_lector());
            prestamo.setId_libro(Integer.parseInt(idLibro));
            prestamo.setFecha_prestamo(Date.valueOf(fechaPrestamo));
            prestamo.setFecha_devolucion(Date.valueOf(fechaDevolucion));
            prestamo.setEstado("Prestado");

            PrestamoDAO prestamoDAO = new PrestamoDAO();

            if (prestamoDAO.registrarPrestamo(prestamo)) {

                LibroDAO libroDAO = new LibroDAO();

                libroDAO.actualizarEstadoLibro(
                        prestamo.getId_libro(),
                        "Prestado"
                );

                response.sendRedirect("SvPrestamos?mensaje=registrado");

            } else {

                request.setAttribute("mensaje", "No fue posible registrar el préstamo.");

                LibroDAO dao = new LibroDAO();
                request.setAttribute("buscar", "");
                request.setAttribute("listaLibros", dao.listarLibrosDisponibles(""));

                request.getRequestDispatcher("prestamos.jsp").forward(request, response);

            }

        }

    }
}
