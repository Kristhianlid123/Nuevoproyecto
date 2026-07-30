<%-- 
    Document   : login
    Created on : 21/07/2026, 2:19:27 p. m.
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">
    <title>Gestor de Biblioteca</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>

        *{
            margin:0;
            padding:0;
            box-sizing:border-box;
            font-family:Arial, Helvetica, sans-serif;
        }

        body{

            background:linear-gradient(135deg,#5c00c7,#9a2cff);

            display:flex;
            justify-content:center;
            align-items:center;

            height:100vh;

        }

        .login-box{

            width:500px;

            background:white;

            border-radius:18px;

            padding:45px;

            box-shadow:0px 10px 30px rgba(0,0,0,.25);

        }

        .logo{

            display:block;

            margin:auto;

            width:120px;

            margin-bottom:20px;

        }

        h1{

            text-align:center;

            margin-bottom:35px;

            font-weight:bold;

        }

        label{

            font-size:20px;

            margin-bottom:8px;

        }

        .form-control{

            height:50px;

            border-radius:10px;

            margin-bottom:20px;

        }

        .form-control:focus{

            border-color:#7a22ff;

            box-shadow:0 0 8px rgba(122,34,255,.4);

        }

        .btn-login{

            width:100%;

            height:50px;

            border:none;

            border-radius:10px;

            color:white;

            font-size:20px;

            font-weight:bold;

            background:linear-gradient(90deg,#6a11cb,#8e2de2);

            transition:.3s;

        }

        .btn-login:hover{

            transform:scale(1.02);

            background:linear-gradient(90deg,#5d0db3,#7c23d0);

        }

    </style>

</head>

<body>

    <div class="login-box">

        <img src="img/logo.png" class="logo">

        <h1>Iniciar Sesión</h1>

        <form action="SvLogin" method="POST">

            <div class="mb-3">

                <label>Usuario</label>

                <input
                    type="text"
                    name="usuario"
                    class="form-control"
                    placeholder="Ingrese su usuario"
                    required>

            </div>

            <div class="mb-4">

                <label>Contraseña</label>

                <input
                    type="password"
                    name="contrasena"
                    class="form-control"
                    placeholder="Ingrese su contraseña"
                    required>

            </div>

            <button class="btn-login">

                Ingresar

            </button>

        </form>

        <%
            String mensaje=(String)request.getAttribute("mensaje");

            if(mensaje!=null){
        %>

            <div class="alert alert-danger mt-4 text-center">

                <%=mensaje%>

            </div>

        <%
            }
        %>

    </div>

</body>

</html>