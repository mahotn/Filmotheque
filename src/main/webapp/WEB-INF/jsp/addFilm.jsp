<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Conditional treatment -->
			<c:choose>
				<c:when test="${user != null }">
					<!-- Add film -->
					<button type="button" class="btn btn-primary" id="addFilmButton">Ajouter un film</button>
					<div class="add-film-container rounded-corners disabled" id="addFilmForm">
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
				</c:when>
			</c:choose>