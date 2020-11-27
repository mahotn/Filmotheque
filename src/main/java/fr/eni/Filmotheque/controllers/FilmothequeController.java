package fr.eni.Filmotheque.controllers;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import fr.eni.Filmotheque.bo.Categorie;
import fr.eni.Filmotheque.bo.Film;
import fr.eni.Filmotheque.bo.Individu;
import fr.eni.Filmotheque.bo.User;
import fr.eni.Filmotheque.services.CategorieService;
import fr.eni.Filmotheque.services.FilmService;
import fr.eni.Filmotheque.services.UserService;
import fr.eni.Filmotheque.services.IndividuService;

@Controller
@SessionAttributes({"listeFilms"})
public class FilmothequeController {
	// Injection des services.
	private FilmService filmService;
	private CategorieService categorieService;
	private IndividuService individuService;
	

	// Constructeur avec injection du service.
	public FilmothequeController(FilmService filmService, CategorieService categorieService, IndividuService individuService) {
		this.filmService = filmService;
		this.categorieService = categorieService;
		this.individuService = individuService;
		
	}

	@ModelAttribute("film")
	public Film getAttributFilm() {
		return new Film();
	}

	@GetMapping({"", "/", "/index"})
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
	
	@GetMapping("/addFilm")
	public String addFilm(Model response) {
		// On récupère les catégories de films afin de les ajouter au select du formulaire
		List<Individu> realisateurs = this.individuService.findAllRealisateur();
		System.out.println("Liste des réal dans le controlleur"+realisateurs);
		List<Categorie> categories = this.categorieService.getCategories();
		response.addAttribute("categories", categories);
		response.addAttribute("realisateurs", realisateurs);
		return "addFilm";
	}

	@PostMapping("/addFilm")
	public String addFilm(@ModelAttribute("film") Film film) {
		// Appel de la méthode pour ajouter un film.
		this.filmService.addFilm(film);
		return "redirect:index";
	}
	
	@GetMapping("/editFilms")
	public String editFilms(Model response) {
		// On récupère les catégories de films afin de les ajouter au select du formulaire.
		List<Categorie> categories = this.categorieService.getCategories();
		// On récupère la liste des films.
		List<Film> liste = this.filmService.listAllFilms();
		System.out.println("La liste des films dans le controller : " + liste);
		// On envoie la liste de film et les catégories de la base vers le front.
		response.addAttribute("categories", categories);
		response.addAttribute("listfilms", liste);
		return "editFilms";
	}
	
	@GetMapping("/editFilm")
	public String editForm(@RequestParam Long id, Model response) {
		System.out.println("Entrée dans la méthode editFilm requête GET");
		System.out.println("Le param id : " + id);
		
		// On récupère les catégories de films afin de les ajouter au select du formulaire.
		List<Categorie> categories = this.categorieService.getCategories();
		response.addAttribute("categories", categories);
		
		// On charge le film dans le formulaire.
		Film film = this.filmService.findFilmDetails(id);
		System.out.println("Le film rec : " + film);
		response.addAttribute("film", film);
		
		return "editFilm";
	}

	@PostMapping("/editFilm")
	public String edit(@ModelAttribute("film") Film film) {
		System.out.println("Le film à éditer : " + film);
		this.filmService.editFilm(film);
		return "redirect:index";
	}
	
	@GetMapping("/deleteFilms")
	public String deleteFilms(Model response) {
		// On récupère les catégories de films afin de les ajouter au select du formulaire.
		List<Categorie> categories = this.categorieService.getCategories();
		// On récupère la liste des films.
		List<Film> liste = this.filmService.listAllFilms();
		System.out.println("La liste des films dans le controller : " + liste);
		// On envoie la liste de film et les catégories de la base vers le front.
		response.addAttribute("categories", categories);
		response.addAttribute("listfilms", liste);
		return "deleteFilms";
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
		System.out.println("Les avis : " + film);
		
		response.addAttribute("detailsFilm", film);
	
		return "details";
	}
}
