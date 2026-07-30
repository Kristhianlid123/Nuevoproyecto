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

    String buscar = (String) request.getAttribute("buscar");
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

            <form action="SvLibros" method="GET" class="mb-4">

                <div class="row">

                    <div class="col-md-6">

                        <input
                            type="text"
                            class="form-control"
                            name="buscar"
                            placeholder="Buscar por título o autor"
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

                        <a
                            href="registrarLibro.jsp"
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

                            No se encontraron libros.

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

            <%
                }
            %>

        </div>

    </body>

</html>
