<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Inicio extends CI_Controller{

    public function __construct() {
        parent::__construct();
        $validacion = $this->session->has_userdata("session_mvc");
        if ($validacion) {
            $session = $this->session->userdata("session_mvc");
            if ($session['tipo'] == "VENDEDOR" && $session['estado'] == "ACTIVO") {
                return false;
            } else {
                redirect('Login/cerrarSession', 'refresh');
                die();
            }
            
        } else {
            redirect('Login/cerrarSession', 'refresh');
            die();
        }
        
    }
    public function index(){
        $data['session'] = $this->session->userdata("session_mvc");
        $this->load->view('vendedor/inicio', $data);
    }
}