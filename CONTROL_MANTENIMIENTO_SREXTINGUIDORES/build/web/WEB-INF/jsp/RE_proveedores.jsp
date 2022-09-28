
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <link href="css_proveedores/reporte.css" rel="stylesheet" type="text/css"/>
        <title>Reporte de Proveedores | Srextinguidores</title>
    </head>
    <body>

        <div class="titulo">
            <h1 class="ti">Reporte de Proveedores</h1>
        </div>


        <div class="reporte">
            <div class="container">
                <div class="botones">
                    <a class="btn btn-dark" onclick="print()">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-printer" viewBox="0 0 16 16">
                        <path d="M2.5 8a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1z"/>
                        <path d="M5 1a2 2 0 0 0-2 2v2H2a2 2 0 0 0-2 2v3a2 2 0 0 0 2 2h1v1a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2v-1h1a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-1V3a2 2 0 0 0-2-2H5zM4 3a1 1 0 0 1 1-1h6a1 1 0 0 1 1 1v2H4V3zm1 5a2 2 0 0 0-2 2v1H2a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-1v-1a2 2 0 0 0-2-2H5zm7 2v3a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1v-3a1 1 0 0 1 1-1h6a1 1 0 0 1 1 1z"/>
                        </svg>
                    </a>
                    <a class="btn btn-warning" href="lproveedores.htm">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-arrow-left-circle-fill" viewBox="0 0 16 16">
                        <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0zm3.5 7.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
                        </svg> Regresar al Menú
                    </a>
                </div>

                <div class="scroll-table">
                    <div class="table-responsive">

                        <table border="1" class="table table-hover">
                            <thead>
                                <tr>
                                    <th class="td">CORRELATIVO</th>
                                    <th class="td">NOMBRE</th>
                                    <th class="td">CALLE</th>
                                    <th class="td">AVENIDA</th>
                                    <th class="td">ZONA</th>
                                    <th class="td">TELEFONO</th>
                                    <th class="td">EMAIL</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dato" items="${lista}">
                                    <tr>
                                        <td class="td">${dato.CORRELATIVO}</td>
                                        <td class="td">${dato.NOMBRE}</td>
                                        <td class="td">${dato.CALLE}</td>
                                        <td class="td">${dato.AVENIDA}</td>
                                        <td class="td">${dato.ZONA}</td>
                                        <td class="td">${dato.TELEFONO}</td>
                                        <td class="td">${dato.CORREO}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>


                    </div>
                </div>
            </div>
        </div>
        
        <div class="marca">
            <h1 class="ma">&COPY;2022 Derechos de Autor</h1>
        </div>

    </body>
</html>
