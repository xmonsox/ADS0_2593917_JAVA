<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="index3.html" class="brand-link">
          <img src="<?= base_url('dist/img/1.png') ?>" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
          <span class="brand-text font-weight-light">EXOTICSOFT</span>
        </a>

        <!-- Sidebar -->
        <!-- Sidebar -->
        <div class="sidebar">
          <!-- Sidebar user panel (optional) -->
          <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
              <img src="<?= base_url('dist/img/users/'.$session['foto']) ?>" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
              <a href="#" class="d-block"><?= explode(" ", $session['nombres'])[0]." ".explode(" ", $session['apellidos'])[0] ?></a>
            </div>
          </div>

          <!-- Sidebar Menu -->
          <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
              <li class="nav-header">MENU ADMIN</li>
                <li class="nav-item">
                    <a href="<?= base_url('index.php/admin/Inicio/openCreateUser') ?>" class="nav-link <?= ($optionSelected=='openCreateUser')? 'active' : '' ?>">
                    <i class="fa-regular fa-user"></i>
                    <p>
                        Crear Usuario
                    </p>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="<?= base_url('index.php/admin/Inicio/listUsers') ?>" class="nav-link <?= ($optionSelected=='listUsers')? 'active' : '' ?>">
                    <i class="fa-solid fa-users"></i>
                        <p>
                            Ver Usuarios
                        </p>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="<?= base_url('index.php/admin/Inicio/modifUsers') ?>" class="nav-link <?= ($optionSelected=='modifUsers')? 'active' : '' ?>">
                    <i class="fa-solid fa-upload"></i>
                        <p>
                            Modificar Usuario
                        </p>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="<?= base_url('index.php/admin/Inicio/deleteUsers') ?>" class="nav-link <?= ($optionSelected=='deleteUsers')? 'active' : '' ?> ">
                    <i class="fa-solid fa-trash"></i>
                        <p>
                            Eliminar Usuario
                        </p>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="<?= base_url('index.php/Login/cerrarSession') ?>" class="nav-link">
                    <i class="fa-solid fa-arrow-right-from-bracket"></i>
                        <p>
                            Cerrar Sesion
                        </p>
                    </a>
                </li>

            </ul>
          </nav>
          <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
      </aside>