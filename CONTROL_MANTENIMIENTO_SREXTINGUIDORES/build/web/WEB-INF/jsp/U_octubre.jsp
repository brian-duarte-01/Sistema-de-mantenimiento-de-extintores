

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link href="css_octubre/actualizar.css" rel="stylesheet" type="text/css"/>
        <title>Actualizar Cliente | Srextinguidores</title>
    </head>
    <body>
        <div class="titulo">
            <h1 class="ti">Actualizar Cliente</h1>
        </div>

        <div class="nuevo">
            <div class="container">
                <form method="POST">
                    <label class="l">NOMBRE</label>
                    <input type="text" name="nombre" value="${lista[0].NOMBRE}" placeholder="Ingrese el Nombre del Cliente" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" required>
                    <label class="l">TOTAL</label>
                    <input type="text" name="valor" value="${lista[0].VALOR}" placeholder="Ingrese el Total de la Factura" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" required>
                    <label class="l">FECHA</label>
                    <input type="date" name="fecha" value="${lista[0].FECHA}" placeholder="Ingrese el Nombre del Cliente" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" required>
                    <label class="l">ESTADO</label>
                    <select class="form-select" name="status" id="validationDefault04" required>
                        <option selected disabled value="">${lista[0].STATUS}</option>
                        <option value="PENDIENTE">PENDIENTE</option>
                        <option value="REALIZADO">REALIZADO</option>
                    </select>

                    <div class="botones">
                        <input type="submit" value="Actualizar" class="btn btn-dark">
                        <a class="btn btn-warning" href="loctubre.htm">
                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-arrow-left-circle-fill" viewBox="0 0 16 16">
                            <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0zm3.5 7.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
                            </svg> Regresar al Menú
                        </a>
                    </div>

                </form>    
            </div>
        </div>

        <div class="marca">
            <h1 class="ma">&COPY;2022 Derechos de Autor</h1>
        </div>
    </body>
</html>
