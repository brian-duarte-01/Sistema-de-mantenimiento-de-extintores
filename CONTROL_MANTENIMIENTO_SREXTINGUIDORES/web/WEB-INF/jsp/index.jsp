<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <link href="css/index.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

        <title>Login | Srextinguidores</title>
    </head>

    <body>

        <div class="login">

            <div class="container">
                <div class="caja">
                    <div class="logo">
                        <svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                            <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                        </svg>
                    </div>

                    <div class="inicio">
                        <form action="login.htm" method="POST">

                            <input type="text" placeholder="Digite su Usuario" class="form-control" name="name"  id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2"  required>


                            <input type="password" placeholder="Digite su Contraseña" class="form-control" name="pass"  id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2"  required>

                            <select class="form-select" name="trol" id="validationDefault04" required>
                                <option selected disabled value="">Elegir una Opción</option>
                                <option value="admin">ADMINISTRADOR</option>
                                <option value="usuario">USUARIO</option>
                            </select>
                            
                            <input type="submit" value="Iniciar Sesión" class="btn btn-warning">
                        </form>
                    </div>
                </div>
            </div>

        </div>
        
        <div class="marca">
            <h1 class="ma">&copy;2022 Derechos de Autor</h1>
        </div>

    </body>
</html>
