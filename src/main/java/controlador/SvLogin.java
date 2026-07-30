package controlador;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Usuario;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("Entró al Servlet SvLogin");

        // Recibir los datos del formulario
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contrasena");
        
        System.out.println("Usuario recibido: [" + usuario + "]");
        System.out.println("Contraseña recibida: [" + contraseña + "]");

        // Crear el DAO
        UsuarioDAO dao = new UsuarioDAO();

        // Validar el usuario
        Usuario usuarioEncontrado = dao.validarLogin(usuario, contraseña);

        // Verificar si existe
        if (usuarioEncontrado != null) {

            request.getSession().setAttribute("usuario", usuarioEncontrado);

            request.getRequestDispatcher("menu.jsp").forward(request, response);

        } else {

            request.setAttribute("mensaje", "Usuario o contraseña incorrectos");

            request.getRequestDispatcher("login.jsp").forward(request, response);

        }

    }
    
    /*prueba*/

}