<%-- 
    Document   : libros
    Created on : 29/07/2026, 5:19:32 p. m.
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Libro"%>

<%
    ArrayList<Libro> listaLibros = (ArrayList<Libro>) request.getAttribute("listaLibros");
%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Libros</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

    <div class="container mt-5">

        <h2>Listado de Libros</h2>

        <hr>

        <table class="table table-bordered table-hover">

            <thead class="table-dark">

                <tr>

                    <th>ID</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Estado</th>

                </tr>

            </thead>

            <tbody>

                <%
                    if (listaLibros != null) {

                        for (Libro libro : listaLibros) {
                %>

                <tr>

                    <td><%= libro.getId_libro()%></td>

                    <td><%= libro.getTitulo()%></td>

                    <td><%= libro.getAutor()%></td>

                    <td><%= libro.getEstado()%></td>

                </tr>

                <%
                        }
                    }
                %>

            </tbody>

        </table>

    </div>

</body>

</html>
