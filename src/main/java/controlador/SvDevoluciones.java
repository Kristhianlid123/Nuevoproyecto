/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.LectorDAO;
import dao.PrestamoDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Lector;
import modelos.Prestamo;
import dao.LibroDAO;

@WebServlet(name = "SvDevoluciones", urlPatterns = {"/SvDevoluciones"})
public class SvDevoluciones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mensaje = request.getParameter("mensaje");
        request.setAttribute("mensaje", mensaje);

        request.getRequestDispatcher("devoluciones.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("buscar".equals(accion)) {

            String documento = request.getParameter("documento");

            if (documento == null || documento.trim().isEmpty()) {

                request.setAttribute("mensaje", "Debe ingresar el documento.");

                request.getRequestDispatcher("devoluciones.jsp")
                        .forward(request, response);
                return;

            }

            LectorDAO lectorDAO = new LectorDAO();

            Lector lector = lectorDAO.buscarPorDocumento(documento);

            if (lector == null) {

                request.setAttribute("mensaje", "El lector no existe.");

                request.getRequestDispatcher("devoluciones.jsp")
                        .forward(request, response);
                return;

            }

            PrestamoDAO prestamoDAO = new PrestamoDAO();

            ArrayList<Prestamo> listaPrestamos
                    = prestamoDAO.listarPrestamosActivos(lector.getId_lector());

            request.setAttribute("listaPrestamos", listaPrestamos);

            request.getRequestDispatcher("devoluciones.jsp")
                    .forward(request, response);

        } else if ("registrar".equals(accion)) {

            String idPrestamo = request.getParameter("idPrestamo");

            if (idPrestamo == null) {

                request.setAttribute("mensaje", "Debe seleccionar un préstamo.");

                request.getRequestDispatcher("devoluciones.jsp")
                        .forward(request, response);
                return;

            }

            PrestamoDAO prestamoDAO = new PrestamoDAO();

            int idLibro = prestamoDAO.obtenerIdLibro(Integer.parseInt(idPrestamo));

            if (prestamoDAO.devolverPrestamo(Integer.parseInt(idPrestamo))) {

                LibroDAO libroDAO = new LibroDAO();

                libroDAO.actualizarEstadoLibro(idLibro, "Disponible");

                response.sendRedirect("SvDevoluciones?mensaje=devuelto");

            } else {

                request.setAttribute("mensaje",
                        "No fue posible registrar la devolución.");

                request.getRequestDispatcher("devoluciones.jsp")
                        .forward(request, response);

            }

        }

    }

}
