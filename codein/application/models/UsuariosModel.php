<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class UsuariosModel extends CI_Model{

    public $table = 'usuarios';
    public $table_id = 'persona_id';

    public function __construct(){
        $this->load->database();
    }
    function insert($data2){
        $this->db->insert($this->table, $data2);
        return $this->db->insert_id();
    }

    public function getAllUsers() {
        // Aquí realizas la consulta a la base de datos para obtener todos los usuarios
        $query = $this->db->get('usuarios'); // 'usuarios' debe ser el nombre de tu tabla
        return $query->result_array(); // Devuelve un arreglo de resultados
        
    }

    public function validarIngreso($email, $password){
        $this->db->select('cedula, email, tipo, estado');
        $this->db->where('email', $email);
        $this->db->where('password', md5($password));
        $this->db->where('estado', 'ACTIVO');
        $registros = $this->db->get('usuarios')->result();
        
        if (sizeof($registros) == 0) {
            return false;
        } else {
            return true;
        }

    }
    public function getUsuarioByEmail($email){
        $this->db->select("cedula, tipo, estado");
        $this->db->where('email', $email);
        $registros = $this->db->get('usuarios')->result();

        if (sizeof($registros) != 0) {
            return $registros[0];
        } else {
            return null;
        }
    }
}