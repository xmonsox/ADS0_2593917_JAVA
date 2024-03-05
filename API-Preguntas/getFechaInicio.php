<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");

    include 'Conexion.php';

    if (!empty($_GET['id_usuario'])) {
        $consulta = $base_de_datos->prepare("SELECT id_usuario, fecha_inicio, id
        FROM cuestionarios WHERE id_usuario = ? ORDER BY fecha_inicio DESC LIMIT 1");
        
        
        $consulta->execute(array($_GET['id_usuario']));
        $datos = $consulta->fetchAll(PDO::FETCH_ASSOC);

        $respuesta = [
            'status' => true,
            'datos_cuestionario' => $datos[0], // Devolver solo el primer resultado, que es el último dato insertado
        ];
        echo json_encode($respuesta);
    } else {
        $respuesta = [
            'status' => false,
            'message' => "ERROR##DATOS##GET",
            '$_GET' => $_GET,
            '$_POST' => $_POST
        ];
        echo json_encode($respuesta);
    }
?>
