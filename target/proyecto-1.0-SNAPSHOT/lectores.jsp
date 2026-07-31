<%-- 
    Document   : Lectores
    Created on : 31/07/2026, 9:56:47 a. m.
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Lector"%>

<%
    ArrayList<Lector> listaLectores = (ArrayList<Lector>) request.getAttribute("listaLectores");

    String buscar = (String) request.getAttribute("buscar");
%>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>Lectores</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    </head>

    <body>

        <div class="container mt-5">

            <h2>Listado de Lectores</h2>
            
            <%
                String mensaje = (String) request.getAttribute("mensaje");

                if (mensaje != null) {

                    String texto = "";

                    switch (mensaje) {

                        case "registrado":
                            texto = "Lector registrado correctamente";
                            break;

                        case "actualizado":
                            texto = "Lector actualizado correctamente";
                            break;

                        case "retirado":
                            texto = "Lector retirado correctamente";
                            break;

                        case "reincorporado":
                            texto = "Lector reincorporado correctamente";
                            break;

                    }
            %>

            <div class="alert alert-success alert-dismissible fade show" role="alert">

                <%= texto%>

                <button type="button"
                        class="btn-close"
                        data-bs-dismiss="alert">
                </button>

            </div>

            <%
                }
            %>

            <form action="SvLectores" method="GET" class="mb-4">

                <div class="row">

                    <div class="col-md-4">

                        <input
                            type="text"
                            class="form-control"
                            name="buscar"
                            placeholder="Buscar por documento o nombre"
                            value="<%= request.getAttribute("buscar") != null ? request.getAttribute("buscar") : ""%>">

                    </div>

                    <div class="col-md-2">

                        <button
                            type="submit"
                            class="btn btn-primary w-100">

                            Buscar

                        </button>

                    </div>

                    <div class="col-md-2">

                        <select
                            name="filtro"
                            class="form-select">

                            <option value="activos"
                                    <%= "activos".equals(request.getAttribute("filtro")) ? "selected" : ""%>>

                                Activos

                            </option>

                            <option value="retirados"
                                    <%= "retirados".equals(request.getAttribute("filtro")) ? "selected" : ""%>>

                                Retirados

                            </option>

                            <option value="todos"
                                    <%= "todos".equals(request.getAttribute("filtro")) ? "selected" : ""%>>

                                Todos

                            </option>

                        </select>

                    </div>

                    <div class="col-md-2">

                        <a
                            href="registrarLector.jsp"
                            class="btn btn-success w-100">

                            Registrar

                        </a>

                    </div>

                    <div class="col-md-2">

                        <a
                            href="menu.jsp"
                            class="btn btn-secondary w-100">

                            Menú

                        </a>

                    </div>

                </div>

            </form>

            <hr>

            <%
                if (buscar != null && !buscar.isEmpty()) {
            %>

            <table class="table table-bordered table-hover">

                <thead class="table-dark">

                    <tr>

                        <th>ID</th>
                        <th>Documento</th>
                        <th>Nombre</th>
                        <th>Teléfono</th>
                        <th>Correo</th>
                        <th>Dirección</th>
                        <th>Acciones</th>

                    </tr>

                </thead>

                <tbody>

                    <%
                        if (listaLectores.isEmpty()) {
                    %>

                    <tr>

                        <td colspan="7" class="text-center">

                            No se encontraron lectores

                        </td>

                    </tr>

                    <%
                    } else {

                        for (Lector lector : listaLectores) {
                    %>

                    <tr>

                        <td><%= lector.getId_lector()%></td>

                        <td><%= lector.getDocumento()%></td>

                        <td><%= lector.getNombre()%></td>

                        <td><%= lector.getTelefono()%></td>

                        <td><%= lector.getCorreo()%></td>

                        <td><%= lector.getDireccion()%></td>

                        <td>

                            <a href="SvEditarLector?id=<%= lector.getId_lector()%>"
                               class="btn btn-warning btn-sm">

                                Editar

                            </a>

                            <% if (lector.isActivo()) {%>

                            <a href="SvRetirarLector?id=<%= lector.getId_lector()%>"
                               class="btn btn-danger btn-sm"
                               onclick="return confirm('¿Desea retirar este lector?');">

                                Retirar

                            </a>

                            <% } else {%>

                            <a href="SvReincorporarLector?id=<%= lector.getId_lector()%>"
                               class="btn btn-success btn-sm"
                               onclick="return confirm('¿Desea reincorporar este lector?');">

                                Reincorporar

                            </a>

                            <% } %>

                        </td>

                    </tr>

                    <%
                            }
                        }
                    %>

                </tbody>

            </table>

            <%
                }
            %>

        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

    </body>

</html>
