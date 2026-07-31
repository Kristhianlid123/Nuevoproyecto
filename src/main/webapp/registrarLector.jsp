<%-- 
    Document   : registrarLector
    Created on : 31/07/2026, 9:57:35 a. m.
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>Registrar Lector</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    </head>

    <body>

        <div class="container mt-5">

            <h2>Registrar Lector</h2>

            <hr>
            <%

                String mensaje = (String) request.getAttribute("mensaje");

                if (mensaje != null) {

            %>

            <div class="alert alert-danger">

                <%= mensaje%>

            </div>

            <%

                }

            %>

            <form action="SvRegistrarLector" method="POST">

                <div class="mb-3">

                    <label class="form-label">

                        Documento

                    </label>

                    <input
                        type="text"
                        name="documento"
                        class="form-control"
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
                        required>

                </div>

                <div class="mb-3">

                    <label class="form-label">

                        Teléfono

                    </label>

                    <input
                        type="text"
                        name="telefono"
                        class="form-control">

                </div>

                <div class="mb-3">

                    <label class="form-label">

                        Correo

                    </label>

                    <input
                        type="email"
                        name="correo"
                        class="form-control">

                </div>

                <div class="mb-3">

                    <label class="form-label">

                        Dirección

                    </label>

                    <input
                        type="text"
                        name="direccion"
                        class="form-control">

                </div>

                <button
                    type="submit"
                    class="btn btn-success">

                    Guardar

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
