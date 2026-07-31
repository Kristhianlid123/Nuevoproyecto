/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.LectorDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Lector;

@WebServlet(name = "SvEditarLector", urlPatterns = {"/SvEditarLector"})
public class SvEditarLector extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        LectorDAO dao = new LectorDAO();

        Lector lector = dao.obtenerLector(id);

        request.setAttribute("lector", lector);

        request.getRequestDispatcher("editarLector.jsp").forward(request, response);

    }

}
