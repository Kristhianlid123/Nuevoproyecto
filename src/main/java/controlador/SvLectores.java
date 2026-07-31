/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.LectorDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Lector;

@WebServlet(name = "SvLectores", urlPatterns = {"/SvLectores"})
public class SvLectores extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Entró al Servlet de Lectores");

        String buscar = request.getParameter("buscar");
        String filtro = request.getParameter("filtro");
        String mensaje = request.getParameter("mensaje");

        if (buscar == null) {
            buscar = "";
        }

        if (filtro == null) {
            filtro = "todos";
        }

        LectorDAO dao = new LectorDAO();

        ArrayList<Lector> listaLectores = dao.listarLectores(buscar, filtro);

        request.setAttribute("listaLectores", listaLectores);
        request.setAttribute("buscar", buscar);
        request.setAttribute("filtro", filtro);
        request.setAttribute("mensaje", mensaje);

        request.getRequestDispatcher("lectores.jsp").forward(request, response);

    }

}
