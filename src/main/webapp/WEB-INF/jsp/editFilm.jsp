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

	<div class="films-container">
			<c:choose>
				<c:when test="${user != null }">
					<c:if test="${user.admin == true }">				
						<!-- Add film -->
						<div class="edit-film-container rounded-corners" id="editFilmForm">
							<form:form method="POST" action="/filmotheque/editFilm" modelAttribute="film">
								<form:input path="id" class="form-control disabled" value="${film.id}"/>
								<div class="mb-3">
									<form:label path="titre" class="form-label">Titre :</form:label>
									<form:input path="titre" class="form-control" value="${film.titre }"/>		
								</div>
										
								<div class="mb-3">
									<form:label path="anneeSortie" class="form-label">Année de sortie :</form:label>
									<form:input path="anneeSortie" class="form-control" value="${film.anneeSortie }" />
								</div>
								
								<div class="mb-3">
									<form:label path="categorie" class="form-label">Catégorie :</form:label>
									<form:select path="categorie" class="form-control">
										<c:forEach items="${categories}" var="categorie">
											<form:option value="${categorie.id}">${categorie.libelle}</form:option>
										</c:forEach>
									</form:select>
								</div>
			
								<input type="submit" class="no-border pl-3 pr-3 pt-2 pb-2 bg-teal white" value="Modifier" />
							</form:form>
						</div>
					</c:if>
				</c:when>
			</c:choose>
		</div>
		</div>
	</div>
</body>
</html>
		