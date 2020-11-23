package fr.eni.Filmotheque.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.Filmotheque.bo.Film;
import fr.eni.Filmotheque.services.FilmService;


@Controller
@SessionAttributes("listeFilms")
public class FilmothequeController {
	// Injection du service film.
	private FilmService filmService;

	// Constructeur avec injection du service.
	public FilmothequeController(FilmService filmService) {
		this.filmService = filmService;
	}
	
	@ModelAttribute("film")
	public Film getAttributPersonne() {
		return new Film();
	}
	
	@GetMapping("/index")
	public String index(Model response) {
		// On récupère la liste des films.
		List<Film> liste = this.filmService.listAllFilms();
		System.out.println("La liste des films dans le controller : " + liste);
		// On envoie la liste de film de la base vers le front.
		response.addAttribute("listfilms", liste );
		return "index";
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
}
