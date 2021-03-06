<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue sur la Filmoth�que</title>
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
		
			<h1 class="absolute-top">Bienvenue sur Filmoth�que</h1>
			
			<div class="films-container">
				
				<div class="table-responsive">
					<table class="table table-vcenter card-table films-list">
						<thead class="bg-teal">
							<th>Titre</th>
							<th>Ann�e de sortie</th>
							<th>Cat�gorie</th>
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
									<a href="/filmotheque/details?id=${film.id}">D�tails</a>
									<c:if test="${user != null }">
										<c:if test="${user.admin == true }">
											<a href="/filmotheque/editFilm?id=${film.id}">Modifier</a>
											<a href="/filmotheque/delete?id=${film.id}">supprimer</a>
										</c:if>
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