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
<script src="js/filmManager.js"></script>
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<!--    AUTOCOMPLETE DEVBRIDGE-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.devbridge-autocomplete/1.2.27/jquery.autocomplete.min.js"></script>
<link rel="stylesheet" href="css/commun.css">
<link rel="icon" href="img/favicon.ico" />


</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container">
	
		<div class="center-screen">
			
			<c:if test="${error != null }">
				<!--  Error message login -->
				<div class="alert alert-warning" role="alert">
					${ error }
				</div>
			</c:if>
			
			<!-- Search form -->
			<div class="search-film-container">
				<form class="mb-3" action="/filmotheque/searchFilm" method="POST">
					<div class="row row-sm">
						<div class="col">
							<input type="text" class="form-control search-film-input" name="film" placeholder="Rechercher un film">
						</div>
						<div class="col-auto">
							<button type="submit" id="search-film-btn" class="btn bg-teal btn-icon"><i class="fas fa-search white" aria-hidden="true" disabled></i></button>
						</div>
					</div>
				</form>
			</div>
			
			<!--  Films list -->
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
									<c:if test="${user != null }">
										<a href="/filmotheque/delete?id=${film.id}">supprimer</a>
									</c:if>
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