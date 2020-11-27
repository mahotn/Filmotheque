<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="navbar navbar-expand-md navbar-light">
		<div class="container-xl">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu"><span class="navbar-toggler-icon"></span></button>
			<!--  Logo -->
			<a href="/filmotheque/index" class="navbar-brand navbar-brand-autodark d-none-navbar-horizontal pr-0 pr-md-3">Filmothèque</a>
			
			<c:if test="${user != null}">
				<c:if test="${user.admin == true }">
					<div class="nav-menu">
						<a href="/filmotheque/addFilm">Ajouter un film</a>
						<a href="/filmotheque/editFilms">Modifier un film</a>
						<a href="/filmotheque/deleteFilms">Supprimer un film</a>
					</div>
				</c:if>
			</c:if>
			
			<!-- Traitement conditionnel pour l'affichage du formulaire de connexion -->
			<c:choose>
				<c:when test="${user != null }">
					<div class="nav-item dropdown">
					<a href="#" class="nav-link d-flex 1h-1 text-reset p-0" data-toggle="dropdown">
						<div class="d-none d-xl-block pl-2">
							<div>
								${user.prenom} ${user.nom }
								<c:if test="${user.admin == true }">
									(admin)
								</c:if>
							</div>
						</div>	
					</a>
					<div class="dropdown-menu dropdown-menu-right">
						<a href="/filmotheque/logout">Déconnexion</a>
					</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="nav-item dropdown">
						<a href="#" class="nav-link d-flex 1h-1 text-reset p-0" data-toggle="dropdown">
							<div class="d-none d-xl-block pl-2">
								<div>Connexion</div>
							</div>	
						</a>
					<div class="dropdown-menu dropdown-menu-right">
						<form method="POST" action="/filmotheque/login" style="padding: 1em;">
							<div class="mb-3">
								<label for="email">Email</label>
								<input type="text" class="form-control" name="email">	
							</div>
							<div class="mb-3">
								<label for="password">Mot de passe</label>
								<input type="password" class="form-control" name="password">	
							</div>
							<div class="mb-3">
								<input type="submit" class="btm btn-primary" value="Connexion">	
							</div>
						</form>
					</div>
				</div> <!--  nav-item -->
				</c:otherwise>
		</c:choose>
		</div> <!-- container -->
	</header>