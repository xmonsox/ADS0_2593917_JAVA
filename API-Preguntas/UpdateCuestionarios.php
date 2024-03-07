<?php 
include 'Conexion.php';

if (!empty($_POST['id'])) {

    $id = $_POST['id'];
    $id_usuario = $_POST['id_usuario'];
    $cant_preguntas = $_POST['cant_preguntas'];
    $cant_ok = $_POST['cant_ok'];
    $cant_error = $_POST['cant_error'];
    $fecha_inicio = $_POST['fecha_inicio'];
    $fecha_fin = $_POST['fecha_fin'];

    try {
        $consulta = $base_de_datos->prepare("UPDATE cuestionarios 
                                             SET id_usuario = :id_usuario, 
                                                 cant_preguntas = :cant_preguntas, 
                                                 cant_ok = :cant_ok, 
                                                 cant_error = :cant_error, 
                                                 fecha_inicio = :fecha_inicio, 
                                                 fecha_fin = :fecha_fin 
                                             WHERE id = :id");

        $consulta->bindParam(':id_usuario', $id_usuario);
        $consulta->bindParam(':cant_preguntas', $cant_preguntas);
        $consulta->bindParam(':cant_ok', $cant_ok);
        $consulta->bindParam(':cant_error', $cant_error);
        $consulta->bindParam(':fecha_inicio', $fecha_inicio);
        $consulta->bindParam(':fecha_fin', $fecha_fin);
        $consulta->bindParam(':id', $id);
        
        $proceso = $consulta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'message' => "OK##CUESTIONARIO##UPDATE"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'message' => "ERROR##CUESTIONARIO##UPDATE"
            ];
            echo json_encode($respuesta);
        }
    } catch (Exception $e) {
        $respuesta = [
            'status' => false,
            'message' => "ERROR##SQL",
            'exception' => $e
        ];
        echo json_encode($respuesta);
    }
} else {
    $respuesta = [
        'status' => false,
        'message' => "ERROR##DATOS##GET",
        'GET' => $_POST
    ];
    echo json_encode($respuesta);
}
?>
