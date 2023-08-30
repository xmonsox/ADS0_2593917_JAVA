<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Inicio extends CI_Controller{

    public function __construct() {
        parent::__construct();
        $this->load->helper('form');
        $this->load->model('PersonasModel');
        $this->load->model('UsuariosModel');
        $this->load->database();
        $validacion = $this->session->has_userdata("session_mvc");
        if ($validacion) {
            $session = $this->session->userdata("session_mvc");
            if ($session['tipo'] == "ADMIN" && $session['estado'] == "ACTIVO") {
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
        $this->load->view('admin/inicio', $data);
    }
    public function OpenCreateUser(){
        $data['session'] = $this->session->userdata("session_mvc");
        $this->load->view('admin/crearUsuario',$data);

        if($this->input->server("REQUEST_METHOD")=="POST"){

            $data1["cedula"] = $this->input->post("cedula");
            $data1["nombres"] = $this->input->post("nombres");
            $data1["apellidos"] = $this->input->post("apellidos");
            $data1["telefono"] = $this->input->post("telefono");
            $data1["email"] = $this->input->post("email");
            $data1["direccion"] = $this->input->post("direccion");
            $data1["foto"] = $this->input->post("foto");

            $data2["cedula"] = $this->input->post("cedula");
            $data2["email"] = $this->input->post("email");
            $data2["password"] = md5($this->input->post("password"));
            $data2["tipo"] = $this->input->post("shirts");
            $data2["estado"] = $this->input->post("estado");    
        
        
            $this->PersonasModel->insert($data1);
            $this->UsuariosModel->insert($data2);
        }

    }
    public function listUsers(){
        $data['session'] = $this->session->userdata("session_mvc");
        $data['users'] = $this->UsuariosModel->getAllUsers();
        $data['personas'] = $this->PersonasModel->getAllUsers();
        $this->load->view('admin/verUsuarios',$data);
        
    }
    public function modifUsers(){
        $data['session'] = $this->session->userdata("session_mvc");
        $this->load->view('admin/modificarUsuario',$data);
    }
    public function deleteUsers($cedula){
        $data['session'] = $this->session->userdata("session_mvc");
        $data['users'] = $this->UsuariosModel->getAllUsers();
        $data['personas'] = $this->PersonasModel->getAllUsers();

        $this->PersonasModel->eliminarPorCedula($cedula);
        echo "enviado";
        redirect('Inicio/listUsers', 'refresh');

        //$this->load->view('admin/deleteUsuario',$data);
    }
}