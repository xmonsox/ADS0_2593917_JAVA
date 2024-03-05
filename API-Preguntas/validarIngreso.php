<?php
	include "Conexion.php";

	if ( (!empty($_POST["correo"]) && !empty($_POST["password"])) || ( !empty($_GET['correo']) && !empty($_GET['password']) ) ) {
		
		$correo = (!empty($_POST['correo']))? $_POST['correo'] : $_GET['correo'];
		$password = (!empty($_POST['password']))? MD5($_POST['password']) : MD5($_GET['password']);

		$consulta = $base_de_datos->prepare("SELECT id_usuario, nombres FROM usuarios WHERE correo = :cor AND password = :pas");
		$consulta->bindParam(":cor", $correo);
		$consulta->bindParam(":pas", $password);
		$consulta->execute();

		$datos = $consulta->fetchAll(PDO::FETCH_ASSOC);
		$datos = mb_convert_encoding($datos, "UTF-8", "iso-8859-1");
		if($datos){
			$respuesta = [
				'status' => true,
				'message' => "USER##FOUND",
				'user' => $datos[0]
			];

			echo json_encode($respuesta);

		}else{
			$respuesta = [
				'status' => false,
				'message' => "USER##NOT##FOUND"
			];

			echo json_encode($respuesta);
		}

	}else{
		$respuesta = [
			'status' => false,
			'message' => "ERROR##DATA"
		];

		echo json_encode($respuesta);
	}
?>