/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.LibroDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Libro;

@WebServlet(name = "SvActualizarLibro", urlPatterns = {"/SvActualizarLibro"})
public class SvActualizarLibro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String estado = request.getParameter("estado");

        Libro libro = new Libro();

        libro.setId_libro(id);
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setEstado(estado);

        LibroDAO dao = new LibroDAO();

        boolean actualizado = dao.actualizarLibro(libro);

        if (actualizado) {

            response.sendRedirect("SvLibros?mensaje=actualizado");

        } else {

            response.getWriter().println("No fue posible actualizar el libro.");

        }

    }

}
