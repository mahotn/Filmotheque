package fr.eni.Filmotheque.webservices;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.Filmotheque.bo.Film;
import fr.eni.Filmotheque.services.FilmService;

@RestController
public class AutocompleteController {
	private FilmService filmService;
	
	public AutocompleteController(FilmService filmService) {
		this.filmService = filmService;
	}

	/**
	 * Réceptionne l'input utilisateur en Ajax pour la recherche de film et renvoie la liste de films qui corresponde dans la base.
	 * @param query
	 * @return
	 */
	@GetMapping(value="/filmAjaxSearch", produces = "application/json")
	public Object filmSearch2(@RequestParam String query) {
		System.out.println("Ajax : " + query);
		List<Film> liste = this.filmService.findFilmByTitle(query);
		System.out.println("Ajax remonté controller : " + liste);
		// On formate le résultat selon le modèle attendu par le webservice autocomplete.
		
		return liste;
	}	
	
	//@GetMapping(value="/filmAjaxSearch/{query}", produces = "application/json")
	//public Object filmSearch(@PathVariable String query) {
	//	System.out.println("Ajax : " + query);
		//List<Film> liste = this.filmService.findFilmByTitle(query);
		//System.out.println("Ajax remonté controller : " + liste);
		// On formate le résultat selon le modèle attendu par le webservice autocomplete.
		
		//return liste;
	//}
}
