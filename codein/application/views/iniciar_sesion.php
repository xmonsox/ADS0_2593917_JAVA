<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<?= base_url('dist/img/1.png') ?>">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.20/dist/sweetalert2.min.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.20/dist/sweetalert2.all.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>Login</title>
</head>
<body>
    <div class="container mt-3">
        <div class=" col-12 row m-0 p-0 justify-content-center">
            <div class="col-12 col-lg-5 mt-3 p-3 px-5 border">
                <h3 class="text-center text-success text-uppercase"><b>Inicio Sesion</b></h3>
                  
                <?php
                if (isset($errorinData)): ?>
                <div class="alert alert-danger">
                    DATOS INCOMPLETOS
                </div>
                <?php endif ?>     
                <?php
                if (isset($datosInvalidos)): ?>
                <div class="alert alert-danger">
                    NO EXISTE UN USUARIO CON ESOS DATOS
                </div>
                <?php endif ?>   
                <form action="<?= base_url('index.php/Login/validarIngreso')?>" method="POST">
                    <label for="campo_email" class="form-label m-0">E-mail:</label>
                    <input class="form-control <?= (isset($valueEmail) && $valueEmail!='')? 'is-valid': ((isset($errorInData))? 'is-invalid':'') ?>" id="campo_email" type="email" name="campo_email" value="<?= (isset($valueEmail))? $valueEmail : '' ?>">

                    <label for="campo_password" class="form-label m-0 mt-3">Passaword:</label>
                    <input class="form-control <?= (isset($valueEmail) && $valuePassword!='')? 'is-valid': ((isset($errorInData))? 'is-invalid':'') ?>" id="campo_password" type="password" name="campo_password" value="<?= (isset($valuePassword))? $valuePassword : '' ?>">

                    <div class="row m-p mt-3 p-0 justify-content-center">
                        <div class="col-12 col-lg-6 m-0 p-0">
                            <button class="col-12 btn btn-success " type="submit" >Iniciar</button>
                        </div>
                    </div>
                </form>
                <div class="col-12 m-0 p-0 mt-3">
                    <div class="col-12 mt-0 p-0">
                        <p class="m-0 p-0">
                            ¿Deseas ser parte del sistema?
                            <a href="#" title="Crear nuevo usuario">Click aqui</a>
                        </p>
                    </div>
                    <div class="col-12 mt-0 p-0">
                        <p class="m-0 p-0">
                            ¿Has olvidado la contraseña?
                            <a href="#" title="Crear nuevo usuario">Recuperar aqui</a>
                        </p>
                    </div>
                </div> 
                

            </div>
        </div>
    </div>   
</body>
</html>