<?php 
    include 'Conexion.php';

    if (!empty($_POST['id_usuario'])) {

        $id_usuario = $_POST['id_usuario'];
        $cant_preguntas = $_POST['cant_preguntas'] ?? 0;
        $cant_ok = $_POST['cant_ok'] ?? 0;
        $cant_error = $_POST['cant_error'] ?? 0;
        //$fecha_inicio = $_POST['fecha_inicio'];
        $fecha_fin = $_POST['fecha_fin'] ?? '0000-00-00 00:00:00';

        try {
            $consulta = $base_de_datos->prepare("INSERT INTO cuestionarios (id_usuario, cant_preguntas, cant_ok, 
                                                cant_error, fecha_inicio, fecha_fin) 
                                                VALUES(:id_u, :cant_p, :cant_o, :cant_e, CURRENT_TIMESTAMP(), :f_f) ");

            $consulta->bindParam(':id_u', $id_usuario);
            $consulta->bindParam(':cant_p', $cant_preguntas);
            $consulta->bindParam(':cant_o', $cant_ok);
            $consulta->bindParam(':cant_e', $cant_error);
            //$consulta->bindParam(':f_i', $fecha_inicio);
            $consulta->bindParam(':f_f', $fecha_fin);
            
            $proceso = $consulta->execute();

            if( $proceso ){
                $respuesta = [
                                'status' => true,
                                'mesagge' => "OK##CUESTIONARIO##INSERT",
                                
                              ];
                echo json_encode($respuesta);
            }else{
                $respuesta = [
                                'status' => false,
                                'mesagge' => "ERROR##CUESTIONARIO##INSERT"
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
