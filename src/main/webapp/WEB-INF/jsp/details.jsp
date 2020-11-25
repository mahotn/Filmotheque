<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue sur la Filmothèque</title>
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/tabler.css">
<script src="https://kit.fontawesome.com/84d3844a78.js" crossorigin="anonymous"></script>
<script src="js/jquery.min.js"></script>
<script src="js/tabler.min.js"></script>
<script src="js/autocomplete.js"></script>
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<!--    AUTOCOMPLETE DEVBRIDGE-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.devbridge-autocomplete/1.2.27/jquery.autocomplete.min.js"></script>
<link rel="stylesheet" href="css/commun.css">
<link rel="icon" href="img/favicon.ico" />


</head>
<body>
	<div class="container">
	
		<div class="center-screen">
		
			<h1 class="absolute-top">Bienvenue sur Filmothèque</h1>
			
			<div class="films-container">
				<div class="page-header">
					<div class="row align-items-center">
						<div class="col-auto">
							<h2 class="page-title">Détails du film ${detailsFilm.titre}</h2>
						</div>
					</div>
				</div>
				
			</div>
			
		</div>
	</div>
</body>
</html>