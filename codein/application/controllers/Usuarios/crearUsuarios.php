<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class crearUsuario extends CI_Controller {
	public function index(){
		$this->load->view('crearUsuario');
	}   
    

    public function validarIngreso(){
        $cedula = $this->input->post('campo_cedula');
        $nombres = $this->input->post('campo_nombres');
        $apellidos = $this->input->post('campo_apellidos');
        $telefono = $this->input->post('campo_telefono');
        $direccion = $this->input->post('campo_direccion');
        $email = $this->input->post('campo_email');
        
        if($cedula!="" && $nombres!="" && $apellidos!="" && $telefono!="" && $direccion!="" && $email!=""){
            $this->load->model('PersonasModel');
            $this->load->model('UsuariosModel');
            $validacion = $this->PersonasModel->validarIngreso($cedula, $nombres, $apellidos, $telefono, $direccion, $email);
            
            if ($validacion) {
                //EXTRAER LOS DATOS DE LA PERSONA Y USUARIO  CON EL FIN DE  PODER CREAR LA VARIABLE DE SESION 
                $datosPersona = $this->PersonasModel->getPersonaByEmail($cedula);
                $datosUsuarios = $this->UsuariosModel->getUsuarioByEmail($cedula);

                //CREAR LA VARIABLE SESION
                $dataUser= [
                                    "cedula" => $datosPersona->cedula, 
                                    "nombres" => $datosPersona->nombres,
                                    "apellidos" => $datosPersona->apellidos,
                                    "telefono" => $datosPersona->telefono,
                                    "direccion" => $datosPersona->direccion,
                                    "email" => $datosPersona->email,
                                ];
                                
                $this->session->set_userdata("createUser", $dataUser);
     
            } else {
                $data['datosInvalidos'] =true;
                $this->load->view('inicio', $data);
            }
        }else{
            $data['errorinData'] =true;
            $data['valueEmail'] =$email;
            $data['valuePassword'] =$password;
            $this->load->view('iniciar_sesion', $data);
        }
    }
    // public function cerrarSession(){
    //     $this->session->sess_destroy();
    //     redirect('Login', 'refresh');
    // }
}
