<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include 'Conexion.php';

    if (!empty($_GET['id'])) {
	    $consulta = $base_de_datos->query("SELECT descripcion FROM opciones WHERE id = ".$_GET['id']);
	    $datos = $consulta->fetchAll(PDO::FETCH_ASSOC);
		
        $respuesta = [
            'status' => true,
            'descripcion' => $datos[0],
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