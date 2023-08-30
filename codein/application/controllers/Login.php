<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class Login extends CI_Controller {
	public function index(){
		$this->load->view('iniciar_sesion');
	}

    public function validarIngreso(){
        $email = $this->input->post('campo_email');
        $password = $this->input->post('campo_password');
        
        if($email!="" && $password!=""){
            $this->load->model('PersonasModel');
            $this->load->model('UsuariosModel');
            $validacion = $this->UsuariosModel->validarIngreso($email, $password);
            
            if ($validacion) {
                //EXTRAER LOS DATOS DE LA PERSONA Y USUARIO  CON EL FIN DE  PODER CREAR LA VARIABLE DE SESION 
                $datosPersona = $this->PersonasModel->getPersonaByEmail($email);
                $datosUsuarios = $this->UsuariosModel->getUsuarioByEmail($email);

                //CREAR LA VARIABLE SESION
                $dataSession = [
                                    "cedula" => $datosPersona->cedula, 
                                    "nombres" => $datosPersona->nombres,
                                    "apellidos" => $datosPersona->apellidos,
                                    "telefono" => $datosPersona->telefono,
                                    "direccion" => $datosPersona->direccion,
                                    "email" => $datosPersona->email,
                                    "foto" => $datosPersona->foto,
                                    "tipo" => $datosUsuarios->tipo,
                                    "estado" => $datosUsuarios->estado,
                                ];
                                
                $this->session->set_userdata("session_mvc", $dataSession);

                //REDIRECIONAR A EL CONTROLADOR INICIAL SEGUN EL TIPO DE USUARIO
                if ($datosUsuarios->tipo == 'ADMIN' ) {
                    redirect('admin/Inicio', 'refresh');
                } else if($datosUsuarios->tipo == 'VENDEDOR' ) {
                    redirect('vendedor/Inicio', 'refresh');
                }else { 
                    redirect('Login', 'refresh');
                }
                
                
            } else {
                $data['datosInvalidos'] =true;
                $this->load->view('iniciar_sesion', $data);
            }
        }else{
            $data['errorinData'] =true;
            $data['valueEmail'] =$email;
            $data['valuePassword'] =$password;
            $this->load->view('iniciar_sesion', $data);
        }
    }
    public function cerrarSession(){
        $this->session->sess_destroy();
        redirect('Login', 'refresh');
    }
}
