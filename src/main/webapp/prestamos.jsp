<%-- 
    Document   : prestamo
    Created on : 31/07/2026, 3:47:22 p. m.
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Libro"%>

<%
    ArrayList<Libro> listaLibros =
            (ArrayList<Libro>) request.getAttribute("listaLibros");
%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Préstamos</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container mt-5">

    <h2>Registrar Préstamo</h2>

    <hr>

    <div class="row">

        <div class="col-md-5">

            <label class="form-label">

                Documento del lector

            </label>

            <input
                type="text"
                class="form-control"
                placeholder="Ingrese el documento">

        </div>

        <div class="col-md-3">

            <label class="form-label">

                Fecha préstamo

            </label>

            <input
                type="date"
                class="form-control">

        </div>

        <div class="col-md-3">

            <label class="form-label">

                Fecha devolución

            </label>

            <input
                type="date"
                class="form-control">

        </div>

    </div>

    <hr>

    <h4>Libros disponibles</h4>

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
            if (listaLibros.isEmpty()) {
        %>

            <tr>

                <td colspan="4" class="text-center">

                    No hay libros disponibles.

                </td>

            </tr>

        <%
            } else {

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

    <a href="menu.jsp" class="btn btn-secondary">

        Volver

    </a>

</div>

</body>

</html>
