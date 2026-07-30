<%-- 
    Document   : editarLibro
    Created on : 30/07/2026, 4:18:57 p. m.
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelos.Libro"%>

<%
    Libro libro = (Libro) request.getAttribute("libro");
%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Editar Libro</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container mt-5">

    <h2>Editar Libro</h2>

    <hr>

    <form action="SvActualizarLibro" method="POST">

        <input
            type="hidden"
            name="id"
            value="<%= libro.getId_libro()%>">

        <div class="mb-3">

            <label class="form-label">

                Título

            </label>

            <input
                type="text"
                name="titulo"
                class="form-control"
                value="<%= libro.getTitulo()%>"
                required>

        </div>

        <div class="mb-3">

            <label class="form-label">

                Autor

            </label>

            <input
                type="text"
                name="autor"
                class="form-control"
                value="<%= libro.getAutor()%>"
                required>

        </div>

        <div class="mb-3">

            <label class="form-label">

                Estado

            </label>

            <select
                name="estado"
                class="form-select">

                <option value="Disponible"
                    <%= libro.getEstado().equals("Disponible") ? "selected" : "" %>>

                    Disponible

                </option>

                <option value="Prestado"
                    <%= libro.getEstado().equals("Prestado") ? "selected" : "" %>>

                    Prestado

                </option>

            </select>

        </div>

        <button
            type="submit"
            class="btn btn-primary">

            Actualizar

        </button>

        <a
            href="SvLibros"
            class="btn btn-secondary">

            Cancelar

        </a>

    </form>

</div>

</body>

</html>
