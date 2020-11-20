package fr.eni.Filmotheque.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.Filmotheque.bo.Film;


@Controller
@SessionAttributes("listeFilms")
public class FilmothequeController {


	// Constructeur avec injection du service.
	public FilmothequeController() {
		
	}
	
	//Date date = dateFormater.parseDate("22/11/2001");
	Date today = new Date();
	
	Film film1 = new Film(1, "Le Seigneur des Anneaux", today);	
	
	@GetMapping("/")
	public String index(Model response) {
		response.addAttribute("film", film1);
		return "index";
	}
}
