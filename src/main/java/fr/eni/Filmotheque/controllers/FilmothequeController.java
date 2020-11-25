package fr.eni.Filmotheque.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.Filmotheque.bo.Categorie;
import fr.eni.Filmotheque.bo.Film;
import fr.eni.Filmotheque.services.CategorieService;
import fr.eni.Filmotheque.services.FilmService;

@Controller
@SessionAttributes("listeFilms")
public class FilmothequeController {
	// Injection du service film.
	private FilmService filmService;
	private CategorieService categorieService;

	// Constructeur avec injection du service.
	public FilmothequeController(FilmService filmService, CategorieService categorieService) {
		this.filmService = filmService;
		this.categorieService = categorieService;
	}

	@ModelAttribute("film")
	public Film getAttributFilm() {
		return new Film();
	}

	@GetMapping("/index")
	public String index(Model response) {
		// On récupère les catégories de films afin de les ajouter au select du formulaire.
		List<Categorie> categories = this.categorieService.getCategories();
		// On récupère la liste des films.
		List<Film> liste = this.filmService.listAllFilms();
		System.out.println("La liste des films dans le controller : " + liste);
		// On envoie la liste de film et les catégories de la base vers le front.
		response.addAttribute("categories", categories);
		response.addAttribute("listfilms", liste);
		return "index";
	}
	
	@PostMapping("/searchFilm")
	public String resultatsRechercheFilms(@RequestParam(name="film") String film, Model response) {
		System.out.println("Le titre du film recherché : " + film);
		List<Film> films = filmService.findFilmByTitle(film);
		System.out.println("Liste des films retrouvés : " + films);
		response.addAttribute("listfilms", films);
		return "resultatsRecherche";
	}

	@PostMapping("/addFilm")
	public String index(@ModelAttribute("film") Film film) {
		// Appel de la méthode pour ajouter un film.
		this.filmService.addFilm(film);
		return "redirect:index";
	}

	@GetMapping("/delete")
	public String index(@RequestParam Long id) {
		System.out.println("Méthode delete dans le controller. Id = " + id);
		this.filmService.deleteFilm(id);
		return "redirect:index";
	}
	
	@GetMapping("/details")
	public String details(@RequestParam Long id, Model response) {
		//System.out.println("Méthode details dans le controller. Id = " + id);
		String msg = "Nous n'avons trouvé aucune information sur ce film";
		Film film = this.filmService.findFilmDetails(id);
		
		response.addAttribute("detailsFilm", film);
	
		return "details";
	}
	
	/**
	 * Réceptionne l'input utilisateur en Ajax pour la recherche de film et renvoie la liste de films qui corresponde dans la base.
	 * @param query
	 * @return
	 */
	@GetMapping(value="/filmAjaxSearch", produces = "application/json")
	@ResponseBody
	public ResponseBody filmSearch(@RequestParam String query) {
		System.out.println("Ajax : " + query);
		List<Film> liste = this.filmService.findFilmByTitle(query);
		
		return null;
	}
}
