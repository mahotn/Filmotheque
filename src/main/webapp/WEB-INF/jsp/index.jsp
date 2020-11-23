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
				<form:form method="POST" action="/filmotheque/addFilm" modelAttribute="film">
					<div class="from-group">
						<form:label path="titre">Titre :</form:label>
						<form:input path="titre" />		
					</div>
							
					<div class="from-group">
						<form:label path="anneeSortie">Année de sortie :</form:label>
						<form:input path="anneeSortie" />
					</div>

					<input type="submit" value="Ajouter" />
				</form:form>
			</div>
			
			<div class="films-container">
			<h3>Liste de tous les films :</h3>
				<ul>
					<c:forEach items="${listfilms}" var="film">
						<li>${film.titre} ${film.anneeSortie} <a href="/filmotheque/delete?id=${film.id}">supprimer</a></li>
					</c:forEach>
				</ul>
			</div>
			
		</div>
	</div>
</body>
</html>