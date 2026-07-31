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

@WebServlet(name = "SvLibros", urlPatterns = {"/SvLibros"})
public class SvLibros extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Entró al Servlet de Libros");

        String buscar = request.getParameter("buscar");
        String filtro = request.getParameter("filtro");
        String mensaje = request.getParameter("mensaje");

        if (buscar == null) {
            buscar = "";
        }

        if (filtro == null) {
            filtro = "todos";
        }
        

        LibroDAO dao = new LibroDAO();

        ArrayList<Libro> listaLibros = dao.listarLibros(buscar, filtro);

        request.setAttribute("listaLibros", listaLibros);
        request.setAttribute("buscar", buscar);
        request.setAttribute("filtro", filtro);
        request.setAttribute("mensaje", mensaje);

        request.setAttribute("mensaje", mensaje);

        request.getRequestDispatcher("libros.jsp").forward(request, response);

    }

}
