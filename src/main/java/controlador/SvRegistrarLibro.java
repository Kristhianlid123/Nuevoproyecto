/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LibroDAO;
import modelos.Libro;

@WebServlet(name = "SvRegistrarLibro", urlPatterns = {"/SvRegistrarLibro"})
public class SvRegistrarLibro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String estado = request.getParameter("estado");

        Libro libro = new Libro();

        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setEstado(estado);

        LibroDAO dao = new LibroDAO();

        boolean registrado = dao.registrarLibro(libro);

        if (registrado) {

            response.sendRedirect("SvLibros");

        } else {

            response.getWriter().println("No fue posible registrar el libro.");

        }

    }

}
