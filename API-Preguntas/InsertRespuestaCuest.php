<?php 
    include 'Conexion.php';

    if (!empty($_POST['id_cuestionario']) AND !empty($_POST['id_pregunta']) AND !empty($_POST['respuesta']) AND !empty($_POST['estado']) AND !empty($_POST['fecha'])) {

        //$id_respuesta = $_POST['id_respuesta'];
        $id_cuestionario = $_POST['id_cuestionario'];
        $id_pregunta = $_POST['id_pregunta'];
        $respuesta = $_POST['respuesta'];
        $estado = $_POST['estado'];
        $fecha = $_POST['fecha'];

        try {
            $consulta = $base_de_datos->prepare("INSERT INTO respuestas (id_cuestionario, id_pregunta, 
                                                respuesta, estado, fecha) 
                                                VALUES(:id_c, :id_p, :resp, :est, :fec) ");

            //$consulta->bindParam(':id_r', $id_respuesta);
            $consulta->bindParam(':id_c', $id_cuestionario);
            $consulta->bindParam(':id_p', $id_pregunta);
            $consulta->bindParam(':resp', $respuesta);
            $consulta->bindParam(':est', $estado);
            $consulta->bindParam(':fec', $fecha);
            
            $proceso = $consulta->execute();

            if( $proceso ){
                $respuesta = [
                                'status' => true,
                                'mesagge' => "OK##RESPUESTA##INSERT",
                                
                              ];
                echo json_encode($respuesta);
            }else{
                $respuesta = [
                                'status' => false,
                                'mesagge' => "ERROR##RESPUESTA##INSERT"
                              ];
                echo json_encode($respuesta);
            }
        } catch (Exception $e) {
            $respuesta = [
                            'status' => false,
                            'mesagge' => "ERROR##SQL",
                            'exception' => $e
                          ];
            echo json_encode($respuesta);
        }
    }else{
        $respuesta = [
                        'status' => false,
                        'mesagge' => "ERROR##DATOS##GET",
                        'GET' => $_POST
                      ];
        echo json_encode($respuesta);
    }
?>
