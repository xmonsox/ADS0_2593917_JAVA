<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include 'Conexion.php';

    if (!empty($_GET['id_usuario'])) {
	    $consulta = $base_de_datos->query("SELECT * FROM cuestionarios WHERE id_usuario = ".$_GET['id_usuario']);
	    $datos = $consulta->fetchAll(PDO::FETCH_ASSOC);
		
        $respuesta = [
            'status' => true,
            'cuestionarios' => $datos,
        ];
        echo json_encode($respuesta);
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