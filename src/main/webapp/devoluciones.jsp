<%-- 
    Document   : devoluciones
    Created on : 3/08/2026, 10:44:45 a. m.
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Prestamo"%>

<%
    ArrayList<Prestamo> listaPrestamos =
        (ArrayList<Prestamo>) request.getAttribute("listaPrestamos");
%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Devoluciones</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container mt-5">

    <h2>Registrar Devolución</h2>
    
    
    <%
        String mensaje = (String) request.getAttribute("mensaje");
        

        if (mensaje != null) {

            String texto = "";
            String tipo = "success";

            switch (mensaje) {

                

                case "devuelto":
                        texto = "Devolución registrada correctamente.";
                        tipo = "success";
                        break;

                    case "Debe completar todos los campos.":
                        texto = mensaje;
                        tipo = "danger";
                        break;

                    case "El lector no existe.":
                        texto = mensaje;
                        tipo = "danger";
                        break;

                    case "Debe seleccionar un préstamo.":
                        texto = mensaje;
                        tipo = "danger";
                        break;

                    case "No fue posible registrar la devolución.":
                        texto = mensaje;
                        tipo = "danger";
                        break;

            }
    %>

    <div class="alert alert-<%= tipo %> alert-dismissible fade show" role="alert">

        <%= texto%>

        <button
            type="button"
            class="btn-close"
            data-bs-dismiss="alert">
        </button>

    </div>

    <%
        }
    %>

    <hr>

    <form action="SvDevoluciones" method="POST">

        <div class="row">

            <div class="col-md-3">

                <label class="form-label">
                    Documento del lector
                </label>

                <input
                    type="text"
                    name="documento"
                    class="form-control"
                    placeholder="Ingrese el documento">

            </div>
            
            <div class="col-md-2 d-flex align-items-end">

                <button
                    type="submit"
                    name="accion"
                    value="buscar"
                    class="btn btn-primary w-100">

                    Buscar

                </button>

            </div>

        </div>



        <hr>

        <h4>Libros prestados</h4>

        <table class="table table-bordered table-hover">

            <thead class="table-dark">

                <tr>
                    <th>Seleccionar</th>
                    <th>ID Prestamo</th>
                    <th>ID libro</th>
                    <th>Fecha Prestamo</th>
                    <th>Fecha Devolucion</th>

                </tr>

            </thead>

            <tbody>

                <%
                    if (listaPrestamos == null || listaPrestamos.isEmpty()) {
                %>

                <tr>

                    <td colspan="4" class="text-center">

                        El lector no tiene préstamos activos

                    </td>

                </tr>

                <%
                } else {

                    for (Prestamo prestamo : listaPrestamos) {
                %>

                <tr>

                    <td>

                        <input
                            type="radio"
                            name="idPrestamo"
                            value="<%= prestamo.getId_prestamo()%>">

                    </td>

                    <td><%= prestamo.getId_prestamo()%></td>

                    <td><%= prestamo.getId_libro()%></td>

                    <td><%= prestamo.getFecha_prestamo()%></td>

                    <td><%= prestamo.getFecha_devolucion()%></td>

                </tr>

                <%
                        }
                    }
                %>

            </tbody>

        </table>

        <div class="mt-3">

            <button
                type="submit"
                name="accion"
                value="registrar"
                class="btn btn-success">

                Registrar devolución

            </button>

        </div>

    </form>

    <a href="menu.jsp" class="btn btn-secondary">

        Volver

    </a>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
