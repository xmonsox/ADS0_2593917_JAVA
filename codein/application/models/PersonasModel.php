<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class PersonasModel extends CI_Model{

    public $table = 'personas';
    public $table_id = 'persona_id';

    public function __construct(){
        $this->load->database();
    }
    function insert($data1){
        $this->db->insert($this->table, $data1);
        return $this->db->insert_id();
    }

    public function getAllUsers() {
        
        $query = $this->db->get('personas'); // 'usuarios' debe ser el nombre de tu tabla
        return $query->result_array(); // Devuelve un arreglo de resultados
        
    }
    public function eliminarPorCedula($cedula) {
        // Realiza la eliminación en la base de datos usando la cédula
        $this->db->where('cedula', $cedula);
        $this->db->delete('personas');
    }

    public function getPersonaByEmail($email){
        $this->db->where('email', $email);
        $registros = $this->db->get('personas')->result();

        if (sizeof($registros) != 0) {
            return $registros[0];
        } else {
            return null;
        }
        
    }
}