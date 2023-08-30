<?php
    $dataHeader['titulo'] = "Crear Usuarios";
    $this->load->view('layouts/header', $dataHeader);
?>
    <?php
        $dataSidebar['titulo'] = $session;
        $dataSidebar['optionSelected'] = 'openCreateUser';
        $this->load->view('layouts/sidebar', $dataSidebar);
    ?>
      <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
    <?php echo form_open(''); ?>
        <div class=" col-12 row m-0 p-0 justify-content-center">
            <div class="col-12 col-lg-5 mt-3 p-3 px-5 border">
                <h3 class="text-center text-success text-uppercase"><b>Crear Usuario</b></h3>
                <form action="<?= base_url('index.php/Usuarios/crearUsuarios/validarIngreso')?>" method="POST">
                <div class="form-group">
                    <?php
                        echo form_label('Cedula:', 'cedula');
                        $data = [
                            'name'      => 'cedula',
                            'type'      => 'text',
                            'value'     => '',
                            'class'     =>'form-control input',
                        ];
                        echo form_input($data);
                    ?>
                </div>
                <div class="form-group">
                    <?php
                        echo form_label('Nombre:', 'nombre');
                        $data = [
                            'name'      => 'nombres',
                            'value'     => '',
                            'class'     =>'form-control input',
                        ];
                        echo form_input($data);
                    ?>
                </div>
                <div class="form-group">
                    <?php
                        echo form_label('Apellido:', 'apellido');
                        $data = [
                            'name'      => 'apellidos',
                            'value'     => '',
                            'class'     =>'form-control input',
                        ];
                        echo form_input($data);
                    ?>
                </div>
                <div class="form-group">
                    <?php
                        echo form_label('E-mail:', 'email');
                        $data = [
                            'name'      => 'email',
                            'value'     => '',
                            'class'     =>'form-control input',
                        ];
                        echo form_input($data);
                    ?>
                </div>
                <div class="form-group">
                    <?php
                        echo form_label('Telefono:', 'telefono');
                        $data = [
                            'name'      => 'telefono',
                            'value'     => '',
                            'class'     =>'form-control input',
                        ];
                        echo form_input($data);
                    ?>
                </div>
                <div class="form-group">
                    <?php
                        echo form_label('Direccion:', 'direccion');
                        $data = [
                            'name'      => 'direccion',
                            'value'     => '',
                            'class'     =>'form-control input',
                        ];
                        echo form_input($data);
                    ?>
                </div>
                <div class="form-group">
                    <?php
                        echo form_label('Password:', 'password');
                        $data = [
                            'name'      => 'password',
                            'type'      => 'password',
                            'value'     => '',
                            'class'     =>'form-control input',
                        ];
                        echo form_input($data);
                    ?>
                </div>
                <div class="form-group mt-3">
                    <?php
                        echo form_label('Tipo:', 'tipo');
                        $data = [
                            'Seleccione...'  => 'Seleccione...',
                            'Vendedor'  => 'Vendedor',
                            'Admin'    => 'admin',
                        ];
                        echo form_dropdown('shirts', $data, 'large');
                    ?>
                </div>
                <div class="form-group">
                    <?php
                        echo form_label('Estado:', 'estado');
                        $data = [
                            'name'      => 'estado',
                            'value'     => 'ACTIVO',
                            'class'     =>'form-control input',
                        ];
                        echo form_input($data);
                    ?>
                </div>
                <div class="form-group">
                    <?php
                        echo form_label('Foto:', 'foto');
                        $data = [
                            'name'      => 'foto',
                            'value'     => 'default.png',
                            'class'     =>'form-control input',
                        ];
                        echo form_input($data);
                    ?>
                </div>
                    <div class="row m-p mt-3 p-0 justify-content-center">
                        <div class="col-12 col-lg-6 m-0 p-0">
                        <?= form_submit('mysubmit', 'Enviar', "class='btn btn-success mt-3 mb-3'"); ?>
                        <?php echo form_close(''); ?>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
<?php  
    $this->load->view('layouts/footer');
?>


