<?php
    $dataHeader['titulo'] = "EXOTICSOFT";
    $this->load->view('layouts/header', $dataHeader);
?>
    <?php
        $dataSidebar['titulo'] = $session;
        $dataSidebar['optionSelected'] = '';
        $this->load->view('layouts/sidebar', $dataSidebar);
    ?>
      <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper"> 
            <div class="col-12 m-0 p-0">
                <h1 class="text-primary text-center">Inicio</h1>
            </div>
    </div>
<?php  
    $this->load->view('layouts/footer');
?>


