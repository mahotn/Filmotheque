<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue sur ChiFouMi</title>
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap-theme.min.css">
<script src="js/jquery.min.js"></script>
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/commun.css">
<link rel="icon" href="img/favicon.ico" />


</head>
<body>

	<div class="container">
	
		<div class="center-screen">
		
			<h1 class="absolute-top">Bienvenue sur Filmothèque</h1>
			
			<div class="player-selection-container box-shadow">
				<form method="POST" action="/chiFouMi/createPlayer">
					<div class="form-group">
						<label for="film">Rechercher un film</label>
						<input type="text" class="form-control" name="film" placeholder="Votre film">
					</div>
					<div class="form-group">
						<input type="submit" class="form-control btn btn-primary" value="Rechercher">
					</div>
				</form>
			</div>
			
			<div class="films-container">
			<h3>Liste de tous les films</h3>
				<p>${film.titre}</p>
			</div>
			
		</div>
	</div>
</body>
</html>