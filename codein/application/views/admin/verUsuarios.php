<?php
    $dataHeader['titulo'] = "Ver Usuarios";
    $this->load->view('layouts/header', $dataHeader);
?>
    <?php
        $dataSidebar['titulo'] = $session;
        $dataSidebar['optionSelected'] = 'listUsers';
        $this->load->view('layouts/sidebar', $dataSidebar);
    ?>
      <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper"> 
        <div class="col-12 m-0 p-0">
            <table class="table">
            <thead>
            <tr scope="col" class="text-center"> <!-- Aplica la clase text-center aquí -->
                <th colspan="6">USUARIOS</th> <!-- Usamos colspan para que el encabezado abarque todas las columnas -->
            </tr>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">CEDULA</th>
                    <th scope="col">E-MAIL</th>
                    <th scope="col">PASSAWORD</th>
                    <th scope="col">TIPO</th>
                    <th scope="col">ESTADO</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($users as $user): ?>
                    <tr>
                        <td><?php echo $user['id']; ?></td>
                        <td><?php echo $user['cedula']; ?></td>
                        <td><?php echo $user['email']; ?></td>
                        <td><?php echo $user['password']; ?></td>
                        <td><?php echo $user['tipo']; ?></td>
                        <td><?php echo $user['estado']; ?></td>
                        <!-- Agrega más celdas de datos según tus datos -->
                    </tr>
                <?php endforeach; ?>
            </tbody>
            </table>
        </div>
        <div class="col-12 m-0 p-0">
            <table class="table">
            <thead>
                <tr scope="col" class="text-center"> <!-- Aplica la clase text-center aquí -->
                    <th colspan="6">PERSONAS</th> <!-- Usamos colspan para que el encabezado abarque todas las columnas -->
                </tr>
                <tr>
                    <th scope="col">CEDULA</th>
                    <th scope="col">NOMBRES</th>
                    <th scope="col">APELLIDOS</th>
                    <th scope="col">TELEFONO</th>
                    <th scope="col">DIRECCION</th>
                    <th scope="col">E-MAIL</th>
                    <th scope="col">FOTO</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($personas as $person): ?>
                    <tr>
                        <td><?php echo $person['cedula']; ?></td>
                        <td><?php echo $person['nombres']; ?></td>
                        <td><?php echo $person['apellidos']; ?></td>
                        <td><?php echo $person['telefono']; ?></td>
                        <td><?php echo $person['direccion']; ?></td>
                        <td><?php echo $person['email']; ?></td>
                        <td><?php echo $person['foto']; ?></td>
                        <!-- Agrega más celdas de datos según tus datos -->
                    </tr>
                <?php endforeach; ?>
            </tbody>
            </table>
        </div>
    </div>
<?php  
    $this->load->view('layouts/footer');
?>


