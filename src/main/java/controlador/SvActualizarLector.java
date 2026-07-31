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

@WebServlet(name = "SvActualizarLector", urlPatterns = {"/SvActualizarLector"})
public class SvActualizarLector extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String documento = request.getParameter("documento");
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");

        Lector lector = new Lector();

        lector.setId_lector(id);
        lector.setDocumento(documento);
        lector.setNombre(nombre);
        lector.setTelefono(telefono);
        lector.setCorreo(correo);
        lector.setDireccion(direccion);

        LectorDAO dao = new LectorDAO();

        boolean actualizado = dao.actualizarLector(lector);

        if (actualizado) {

            response.sendRedirect("SvLectores?mensaje=actualizado");

        } else {

            response.getWriter().println("No fue posible actualizar el lector.");

        }

    }

}
