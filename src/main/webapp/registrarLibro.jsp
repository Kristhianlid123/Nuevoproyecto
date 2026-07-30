<%-- 
    Document   : registrarLibro
    Created on : 30/07/2026, 3:17:45 p. m.
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>Registrar Libro</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    </head>

    <body>

        <div class="container mt-5">

            <h2>Registrar Libro</h2>

            <hr>

            <form action="SvRegistrarLibro" method="POST">

                <div class="mb-3">

                    <label class="form-label">

                        Título

                    </label>

                    <input
                        type="text"
                        name="titulo"
                        class="form-control"
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
                        required>

                </div>

                <div class="mb-3">

                    <label class="form-label">

                        Estado

                    </label>

                    <select
                        name="estado"
                        class="form-select">

                        <option value="Disponible">

                            Disponible

                        </option>

                        <option value="Prestado">

                            Prestado

                        </option>

                    </select>

                </div>

                <button
                    type="submit"
                    class="btn btn-success">

                    Guardar

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
