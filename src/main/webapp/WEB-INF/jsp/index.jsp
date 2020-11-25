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
			
			<!-- Search form -->
			<div class="search-film-container">
				<form class="mb-3" action="" method="POST">
					<div class="row row-sm">
						<div class="col">
							<input type="text" class="form-control search-film-input" placeholder="Rechercher un film">
						</div>
						<div class="col-auto">
							<button type="submit" id="search-film-btn" class="btn bg-teal btn-icon"><i class="fas fa-search white" aria-hidden="true" disabled></i></button>
						</div>
					</div>
				</form>
			</div>
			
			<div class="add-film-container flex-center rounded-corners">
				<form:form method="POST" action="/filmotheque/addFilm" modelAttribute="film">
					<div class="mb-3">
						<form:label path="titre" class="form-label">Titre :</form:label>
						<form:input path="titre" class="form-control" />		
					</div>
							
					<div class="mb-3">
						<form:label path="anneeSortie" class="form-label">Année de sortie :</form:label>
						<form:input path="anneeSortie" class="form-control" />
					</div>
					
					<div class="mb-3">
						<form:label path="categorie" class="form-label">Catégorie :</form:label>
						<form:select path="categorie" class="form-control">
							<c:forEach items="${categories}" var="categorie">
								<form:option value="${categorie.id}">${categorie.libelle}</form:option>
							</c:forEach>
						</form:select>
					</div>

					<input type="submit" class="no-border pl-3 pr-3 pt-2 pb-2 bg-teal white" value="Ajouter" />
				</form:form>
			</div>
			
			<div class="films-container">
				<div class="page-header">
					<div class="row align-items-center">
						<div class="col-auto">
							<h2 class="page-title">Liste des films</h2>
						</div>
					</div>
				</div>
				
				<div class="table-responsive">
					<table class="table table-vcenter card-table films-list">
						<thead class="bg-teal">
							<th>Titre</th>
							<th>Année de sortie</th>
							<th>Catégorie</th>
							<th>Actions</th>
						</thead>
						<tbody>
							<c:forEach items="${listfilms}" var="film">
								<tr>
									<td>
									${film.titre}
									</td>
									<td>
									${film.anneeSortie}
									</td>
									<td>
									${film.categorie.libelle}
									</td>
									<td>
									<a href="/filmotheque/details?id=${film.id}">détails</a>
									<a href="/filmotheque/delete?id=${film.id}">supprimer</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>