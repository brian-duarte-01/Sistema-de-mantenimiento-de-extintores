<%-- 
    Document   : RE_febrero
    Created on : feb 20, 2022, 6:43:30 p.m.
    Author     : BEST COMPUTER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link href="css_febrero/reporte.css" rel="stylesheet" type="text/css"/>
        <title>Reporte | Srextinguidores</title>
    </head>
    <body>
        <div class="titulo">
            <h1 class="ti">Reporte de Clientes en Mantenimiento del Mes de Febrero</h1>
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
                    <a class="btn btn-warning" href="lfebrero.htm">
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
                                    <th class="td">TOTAL</th>
                                    <th class="td">FECHA</th>
                                    <th class="td">ESTADO</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dato" items="${lista}">
                                    <tr>
                                        <td class="td">${dato.ID}</td>
                                        <td class="td">${dato.NOMBRE}</td>
                                        <td class="td">${dato.VALOR}</td>
                                        <td class="td">${dato.FECHA}</td>
                                        <td class="td">${dato.STATUS}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        
        <div class="marca">
            <h1 class="ma">&COPY; 2022 Derechos de Autor</h1>
        </div>
        </body>
    </html>
