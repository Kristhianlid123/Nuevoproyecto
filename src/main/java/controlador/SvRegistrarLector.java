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

@WebServlet(name = "SvRegistrarLector", urlPatterns = {"/SvRegistrarLector"})
public class SvRegistrarLector extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String documento = request.getParameter("documento");
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");

        LectorDAO dao = new LectorDAO();

        if (dao.existeLector(documento)) {

            request.setAttribute("mensaje", "Ya existe un lector con ese documento.");

            request.getRequestDispatcher("registrarLector.jsp").forward(request, response);

            return;

        }

        Lector lector = new Lector();

        lector.setDocumento(documento);
        lector.setNombre(nombre);
        lector.setTelefono(telefono);
        lector.setCorreo(correo);
        lector.setDireccion(direccion);

        boolean registrado = dao.registrarLector(lector);

        if (registrado) {

            response.sendRedirect("SvLectores?mensaje=registrado");

        } else {

            response.getWriter().println("No fue posible registrar el lector.");

        }

    }

}
