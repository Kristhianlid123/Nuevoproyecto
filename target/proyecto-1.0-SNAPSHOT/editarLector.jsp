<%-- 
    Document   : editarLector
    Created on : 31/07/2026, 9:57:50 a. m.
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelos.Lector"%>

<%
    Lector lector = (Lector) request.getAttribute("lector");
%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Editar Lector</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container mt-5">

    <h2>Editar Lector</h2>

    <hr>

    <form action="SvActualizarLector" method="POST">

        <input
            type="hidden"
            name="id"
            value="<%= lector.getId_lector()%>">

        <div class="mb-3">

            <label class="form-label">

                Documento

            </label>

            <input
                type="text"
                name="documento"
                class="form-control"
                value="<%= lector.getDocumento()%>"
                required>

        </div>

        <div class="mb-3">

            <label class="form-label">

                Nombre

            </label>

            <input
                type="text"
                name="nombre"
                class="form-control"
                value="<%= lector.getNombre()%>"
                required>

        </div>

        <div class="mb-3">

            <label class="form-label">

                Teléfono

            </label>

            <input
                type="text"
                name="telefono"
                class="form-control"
                value="<%= lector.getTelefono()%>">

        </div>

        <div class="mb-3">

            <label class="form-label">

                Correo

            </label>

            <input
                type="email"
                name="correo"
                class="form-control"
                value="<%= lector.getCorreo()%>">

        </div>

        <div class="mb-3">

            <label class="form-label">

                Dirección

            </label>

            <input
                type="text"
                name="direccion"
                class="form-control"
                value="<%= lector.getDireccion()%>">

        </div>

        <button
            type="submit"
            class="btn btn-primary">

            Actualizar

        </button>

        <a
            href="SvLectores"
            class="btn btn-secondary">

            Cancelar

        </a>

    </form>

</div>

</body>

</html>
