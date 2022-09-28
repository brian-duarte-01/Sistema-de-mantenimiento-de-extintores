
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <link href="css_proveedores/actualizar.css" rel="stylesheet" type="text/css"/>
        <title>Actualizar Proveedor | Srextinguidores</title>
    </head>
    <body>

        <div class="titulo">
            <h1 class="ti">Actualizar Proveedor</h1>
        </div>


        <div class="actualizar">
            <div class="container">
                <form method="POST" class="row g-3">

                    <div class="col-md-4">
                        <label for="validationDefaultUsername" class="form-label">NOMBRE</label>
                        <div class="input-group">
                            <span class="input-group-text" id="inputGroupPrepend2">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                </svg>
                            </span>
                            <input type="text" name="nombre" value="${lista[0].NOMBRE}" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" required>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <label for="validationDefaultUsername" class="form-label">CALLE</label>
                        <div class="input-group">
                            <span class="input-group-text" id="inputGroupPrepend2">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-signpost-2" viewBox="0 0 16 16">
                                <path d="M7 1.414V2H2a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h5v1H2.5a1 1 0 0 0-.8.4L.725 8.7a.5.5 0 0 0 0 .6l.975 1.3a1 1 0 0 0 .8.4H7v5h2v-5h5a1 1 0 0 0 1-1V8a1 1 0 0 0-1-1H9V6h4.5a1 1 0 0 0 .8-.4l.975-1.3a.5.5 0 0 0 0-.6L14.3 2.4a1 1 0 0 0-.8-.4H9v-.586a1 1 0 0 0-2 0zM13.5 3l.75 1-.75 1H2V3h11.5zm.5 5v2H2.5l-.75-1 .75-1H14z"/>
                                </svg>
                            </span>
                            <input type="number" name="calle" value="${lista[0].CALLE}" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" required>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <label for="validationDefaultUsername" class="form-label">AVENIDA</label>
                        <div class="input-group">
                            <span class="input-group-text" id="inputGroupPrepend2">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-signpost" viewBox="0 0 16 16">
                                <path d="M7 1.414V4H2a1 1 0 0 0-1 1v4a1 1 0 0 0 1 1h5v6h2v-6h3.532a1 1 0 0 0 .768-.36l1.933-2.32a.5.5 0 0 0 0-.64L13.3 4.36a1 1 0 0 0-.768-.36H9V1.414a1 1 0 0 0-2 0zM12.532 5l1.666 2-1.666 2H2V5h10.532z"/>
                                </svg>
                            </span>
                            <input type="text" name="avenida" value="${lista[0].AVENIDA}" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" required>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <label for="validationDefaultUsername" class="form-label">ZONA</label>
                        <div class="input-group">
                            <span class="input-group-text" id="inputGroupPrepend2">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-signpost-split" viewBox="0 0 16 16">
                                <path d="M7 7V1.414a1 1 0 0 1 2 0V2h5a1 1 0 0 1 .8.4l.975 1.3a.5.5 0 0 1 0 .6L14.8 5.6a1 1 0 0 1-.8.4H9v10H7v-5H2a1 1 0 0 1-.8-.4L.225 9.3a.5.5 0 0 1 0-.6L1.2 7.4A1 1 0 0 1 2 7h5zm1 3V8H2l-.75 1L2 10h6zm0-5h6l.75-1L14 3H8v2z"/>
                                </svg>
                            </span>
                            <input type="number" name="zona" value="${lista[0].ZONA}" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" required>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <label for="validationDefaultUsername" class="form-label">TELEFONO</label>
                        <div class="input-group">
                            <span class="input-group-text" id="inputGroupPrepend2">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-telephone-plus" viewBox="0 0 16 16">
                                <path d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                                <path fill-rule="evenodd" d="M12.5 1a.5.5 0 0 1 .5.5V3h1.5a.5.5 0 0 1 0 1H13v1.5a.5.5 0 0 1-1 0V4h-1.5a.5.5 0 0 1 0-1H12V1.5a.5.5 0 0 1 .5-.5z"/>
                                </svg>
                            </span>
                            <input type="number" name="telefono" value="${lista[0].TELEFONO}" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" required>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <label for="validationDefaultUsername" class="form-label">EMAIL</label>
                        <div class="input-group">
                            <span class="input-group-text" id="inputGroupPrepend2">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-envelope-plus" viewBox="0 0 16 16">
                                <path d="M2 2a2 2 0 0 0-2 2v8.01A2 2 0 0 0 2 14h5.5a.5.5 0 0 0 0-1H2a1 1 0 0 1-.966-.741l5.64-3.471L8 9.583l7-4.2V8.5a.5.5 0 0 0 1 0V4a2 2 0 0 0-2-2H2Zm3.708 6.208L1 11.105V5.383l4.708 2.825ZM1 4.217V4a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v.217l-7 4.2-7-4.2Z"/>
                                <path d="M16 12.5a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0Zm-3.5-2a.5.5 0 0 0-.5.5v1h-1a.5.5 0 0 0 0 1h1v1a.5.5 0 0 0 1 0v-1h1a.5.5 0 0 0 0-1h-1v-1a.5.5 0 0 0-.5-.5Z"/>
                                </svg>
                            </span>
                            <input type="email" name="correo" value="${lista[0].CORREO}" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" required>
                        </div>
                    </div>

                    <div class="botones1">
                        <input type="submit" value="Enviar Formulario" class="btn btn-dark">
                        <a class="btn btn-warning" href="lproveedores.htm">
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
