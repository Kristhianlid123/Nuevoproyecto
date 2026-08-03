<%-- 
    Document   : menu
    Created on : 21/07/2026, 2:40:34 p. m.
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelos.Usuario"%>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>Menú Principal</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

        <style>

            *{

                margin:0;
                padding:0;
                box-sizing:border-box;

            }

            body{

                background:#ECE9F8;
                font-family:Arial, Helvetica, sans-serif;

            }

            .encabezado{

                background:linear-gradient(90deg,#5d0ec0,#8b2be2);
                color:white;
                padding:20px;

                display:flex;
                justify-content:space-between;
                align-items:center;

            }

            .logo{

                width:80px;

            }

            .tituloSistema{

                font-size:35px;
                font-weight:bold;

            }

            .subtitulo{

                font-size:18px;

            }

            .buscar{

                width:280px;

            }

            .menu{

                background:#4b0aa8;
                padding:15px;

                text-align:right;

            }

            .menu a{

                color:white;
                text-decoration:none;
                margin-left:25px;
                font-weight:bold;

            }

            .menu a:hover{

                color:#ffc107;

            }

            .contenido{

                width:90%;
                margin:auto;
                margin-top:35px;

            }

            .bienvenida{

                margin-bottom:40px;

            }

            .opciones{

                display:flex;
                justify-content:center;
                flex-wrap:wrap;
                gap:40px;

            }

            .tarjeta{

                width:250px;
                background:white;
                border-radius:15px;
                padding:20px;
                text-align:center;

                box-shadow:0px 5px 15px rgba(0,0,0,.2);

                transition:.3s;

            }

            .tarjeta:hover{

                transform:translateY(-8px);

            }

            .imagen{

                width:90px;
                height:90px;
                margin-bottom:15px;

            }

            .titulo{

                font-size:25px;
                font-weight:bold;

            }

            .descripcion{

                margin-top:10px;
                margin-bottom:20px;
                color:#666;

            }

            .pie{

                margin-top:60px;
                background:#4b0aa8;
                color:white;
                text-align:center;
                padding:18px;

            }

        </style>

    </head>

    <body>

        <div class="encabezado">

            <div>

                <img src="img/logo.png" class="logo">

            </div>

            <div>

                <div class="tituloSistema">

                    Sistema Biblioteca

                </div>

                <div class="subtitulo">

                    Gestión de libros y préstamos

                </div>

            </div>

            <div class="buscar">

                <input
                    type="text"
                    class="form-control"
                    placeholder="Buscar libros">

            </div>

        </div>

        <div class="menu">

            <a href="#">Inicio</a>

            <a href="#">Perfil</a>

            <a href="login.jsp">Cerrar sesión</a>

        </div>

        <div class="contenido">

            <div class="bienvenida">

                <h2>

                    Bienvenido,
                    <%= usuario.getNombre()%>

                </h2>

                <h4>

                    Rol:
                    <%= usuario.getRol()%>

                </h4>

            </div>



            <%
                if (usuario.getRol().equalsIgnoreCase("Admin")) {
            %>

            <div class="opciones">

                <div class="tarjeta">

                    <img src="img/libros.png" class="imagen">

                    <div class="titulo">
                        Libros
                    </div>

                    <div class="descripcion">
                        Registrar, consultar y modificar libros
                    </div>

                    <a href="SvLibros" class="btn btn-primary">

                        Entrar

                    </a>

                </div>

                <div class="tarjeta">

                    <img src="img/prestamo.jpg" class="imagen">

                    <div class="titulo">
                        Préstamos
                    </div>

                    <div class="descripcion">
                        Registrar préstamos de libros
                    </div>

                    <a href="SvPrestamos" class="btn btn-primary">
                        Entrar
                    </a>

                </div>

                <div class="tarjeta">

                    <img src="img/Devolucion1.jpg.png" class="imagen">

                    <div class="titulo">
                        Devoluciones
                    </div>

                    <div class="descripcion">
                        Registrar devoluciones
                    </div>

                    <a href="SvDevoluciones" class="btn btn-primary">
                        Entrar
                    </a>

                </div>

                <div class="tarjeta">

                    <img src="img/usuarios.png" class="imagen">

                    <div class="titulo">
                        Lectores
                    </div>

                    <div class="descripcion">
                        Administrar los lectores de la biblioteca
                    </div>

                    <a href="SvLectores" class="btn btn-primary">
                        Entrar
                    </a>

                </div>

            </div>

            <%
            } else {
            %>

            <div class="opciones">

                <div class="tarjeta">

                    <img src="img/prestamo.jpg" class="imagen">

                    <div class="titulo">
                        Préstamos
                    </div>

                    <div class="descripcion">
                        Registrar préstamos de libros
                    </div>

                    <a href="SvPrestamos" class="btn btn-primary">
                        Entrar
                    </a>

                </div>

                <div class="tarjeta">

                    <img src="img/Devolucion1.jpg.png" class="imagen">

                    <div class="titulo">
                        Devoluciones
                    </div>

                    <div class="descripcion">
                        Registrar devoluciones
                    </div>

                    <button class="btn btn-primary">
                        Entrar
                    </button>

                </div>

            </div>

            <%
                }
            %>

        </div>

    </div>

    <div class="pie">

        Sistema Biblioteca © 2026

    </div>

</body>

</html>