<?php
    $dataHeader['titulo'] = "Modificar Usuarios";
    $this->load->view('layouts/header', $dataHeader);
?>
    <?php
        $dataSidebar['titulo'] = $session;
        $dataSidebar['optionSelected'] = 'modifUsers';
        $this->load->view('layouts/sidebar', $dataSidebar);
    ?>
      <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper"> 
            <div class="col-12 m-0 p-0">
                <h1 class="text-primary text-center">modificar usuarios</h1>
            </div>
    </div>
<?php  
    $this->load->view('layouts/footer');
?>


