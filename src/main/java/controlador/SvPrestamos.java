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

@WebServlet(name = "SvPrestamos", urlPatterns = {"/SvPrestamos"})
public class SvPrestamos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LibroDAO dao = new LibroDAO();

        ArrayList<Libro> listaLibros
                = dao.listarLibrosDisponibles();

        request.setAttribute("listaLibros", listaLibros);

        request.getRequestDispatcher("prestamos.jsp")
                .forward(request, response);

    }

}
