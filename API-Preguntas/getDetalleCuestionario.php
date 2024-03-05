<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");
    include 'Conexion.php';
    if (!empty($_GET['id_cuestionario'])) {
        $id_consulta = $_GET['id_cuestionario'];
	    $consulta_preguntas = $base_de_datos->prepare("SELECT * FROM respuestas WHERE id_cuestionario = $id_consulta");
        $consulta_preguntas->execute();
        $preguntas = $consulta_preguntas->fetchAll(PDO::FETCH_ASSOC);
        if($preguntas){
            $respuesta = [
                'status' => true,
                'message' => 'OK',
                'respuesta' => []
            ];
            foreach ($preguntas as $pregunta) {
                $id_respuesta = $pregunta['id_pregunta'];
                $consulta_pregunta = $base_de_datos->prepare("SELECT preguntas.id, preguntas.descripcion, preguntas.id_correcta, preguntas.url_imagen, respuestas.id_respuesta, respuestas.respuesta, respuestas.estado 
                                                                FROM preguntas 
                                                                JOIN respuestas ON respuestas.id_pregunta = preguntas.id
                                                                WHERE id= :id_resp AND respuestas.id_cuestionario = $id_consulta");
                $consulta_pregunta->bindParam(':id_resp', $id_respuesta);
                $consulta_pregunta->execute();
                $pregunta = $consulta_pregunta->fetch(PDO::FETCH_ASSOC);

                if($pregunta){
                    $opciones = $base_de_datos->prepare("SELECT * FROM opciones WHERE id_pregunta= :id_resp");
                    $opciones->bindParam(':id_resp', $id_respuesta);
                    $opciones->execute();
                    $opcion = $opciones->fetchAll(PDO::FETCH_ASSOC);

                    $respuesta['respuesta'][] = [
                        'pregunta' => $pregunta,
                        'opciones' => $opcion
                    ];
                }
            }    
            echo json_encode($respuesta);
        }
	}else{
        $respuesta = [
                        'status' => false,
                        'mesagge' => "ERROR##DATOS##GET",
                        '$_GET' => $_GET,
                        '$_POST' => $_POST
                    ];
        echo json_encode($respuesta);
    }
?>