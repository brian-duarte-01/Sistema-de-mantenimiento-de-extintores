<%-- 
    Document   : C_abril
    Created on : ene 25, 2022, 5:56:48 p.m.
    Author     : BEST COMPUTER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="css_abril/agregar.css" rel="stylesheet" type="text/css"/>
        <title>Nuevo Cliente | Srextinguidores</title>
    </head>
    <body>
        <div class="titulo">
            <h1 class="ti">Nuevo Cliente</h1>
        </div>


        <div class="nuevo">
            <div class="container">
                <form method="POST">
                    <label class="l">CORRELATIVO</label>
                    <input type="text" name="id" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" placeholder="Ingrese el Correlativo" required>
                    <label class="l">NOMBRE</label>
                    <input type="text" name="nombre" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" placeholder="Ingrese el Nombre del Cliente" required>
                    <label class="l">TOTAL</label>
                    <input type="text" name="valor" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" placeholder="Ingrese el Total de la Factura" required>
                    <label class="l">FECHA</label>
                    <input type="date" name="fecha" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2"  required>
                    <label class="l">ESTADO</label>
                    <select name="status" class="form-select" id="validationDefault04" required>
                        <option selected disabled value="">Elegir una opción</option>
                        <option value="PENDIENTE">PENDIENTE</option>
                        <option value="REALIZADO">REALIZADO</option>
                    </select>

                    <div class="botones">
                        <input type="submit" class="btn btn-dark" value="Nuevo">
                        <a class="btn btn-warning" href="labril.htm">
                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-arrow-left-circle-fill" viewBox="0 0 16 16">
                            <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0zm3.5 7.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
                            </svg> Regresar al Menú</a>
                    </div>
                </form>
            </div>
        </div>

        <div class="marca">
            <h1 class="ma">&COPY;2022 Derechos de Autor</h1>
        </div>
    </body>
</html>
