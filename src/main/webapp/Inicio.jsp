<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String) session.getAttribute("id");
	String[] usuario = (String[]) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Inicio</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form p-l-55 p-r-55 p-t-150 p-b-100">
					<%if(usuario != null){ %>
					<span class="login100-form-title">
						¡Bienvenido <%= usuario[1] %>!
					</span>
					<%}else{ %>
						<span class="login100-form-title">
						¡Bienvenido!
						</span>
					<%} %>
					
					<%if(id.equals("Logueado")){ %>
						<p class=" txt1 p-t-50">Esta es la página de inicio de su cuenta de Login.</p>

						<div class="container-login100-form-btn p-t-50">
						
						
							<button class="login100-form-btn">
								<a href="svlLogin?id=login">Cerrar Sesión</a>
							</button>
						
						</div>
					<%} else if(id.equals("ClaveErronea")){ %>
						<p class="txt1 p-t-50">Verificamos que la clave ingresada es incorrecta. Por favor realizar el Login con los datos correspondientes.</p>

						<div class="container-login100-form-btn p-t-50">
							<button class="login100-form-btn" href="svlLogin?id=cambiarContraseña">
								<a href="svlLogin?id=login">Ir a Login</a>
							</button>
						</div>
					<%} else if(id.equals("UsuarioCreado")){ %>
						<p class="txt1 p-t-50">Su cuenta ha sido creada satisfactoriamente, Por favor dirigase al Login para verificar el correcto acceso. Gracias</p>

						<div class="container-login100-form-btn p-t-50">
							<button class="login100-form-btn" href="svlLogin?id=cambiarContraseña">
								<a href="svlLogin?id=login">Ir a Login</a>
							</button>
						</div>
					<%} else if(id.equals("ClaveActualizada")){ %>
						<p class="txt1 p-t-50">Su contraseña fue correctamente actualizada. Los datos requeridos para el Login fueron enviados al correo: <%=usuario[2] %>.Gracias</p>

						<div class="container-login100-form-btn p-t-50">
							<button class="login100-form-btn" href="svlLogin?id=cambiarContraseña">
								<a href="svlLogin?id=login">Ir a Login</a>
							</button>
						</div>
					<%} else if(id.equals("UsuarioEnBD")){ %>
						<p class="txt1 p-t-50">Recuerda que ya tienes una cuenta registrada con el correo <%=usuario[2]%>. Si haz olvidado la contraseña puedes acceder a dicha opción desde el Login, para el correto acceso a la Web.Gracias</p>

						<div class="container-login100-form-btn p-t-50">
							<button class="login100-form-btn" href="svlLogin?id=cambiarContraseña">
								<a href="svlLogin?id=login">Ir a Login</a>
							</button>
						</div>
					<%} else if(id.equals("CorreoNoExiste")){ %>
						<p class="txt1 p-t-50">El correo proporcionado no cuenta con una cuenta asociada en la Web. Por favor tiene que crear una cuenta.Gracias</p>

						<div class="container-login100-form-btn p-t-50">
							<button class="login100-form-btn" href="svlLogin?id=cambiarContraseña">
								<a href="svlLogin?id=crearCuenta">Crear Cuenta</a>
							</button>
						</div>
					<%} %>
					
				</form>
			</div>
		</div>
	</div>
	
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>