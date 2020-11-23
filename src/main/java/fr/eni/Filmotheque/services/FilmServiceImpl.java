package fr.eni.Filmotheque.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.Filmotheque.bo.Film;
import fr.eni.Filmotheque.dal.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService{

	private FilmRepository filmDAO;
	
	public FilmServiceImpl(FilmRepository filmDAO) {
		this.filmDAO = filmDAO;
	}
	
	/**
	 * Méthode pour ajouter un film. Prend un objet de type Film en paramètre.
	 */
	@Override
	public void addFilm(Film film) {
		filmDAO.save(film);
	}

	/**
	 * Méthode pour effacer un film. Prend un ID de type Long en paramètre.
	 */
	@Override
	public void deleteFilm(Long id) {
		filmDAO.deleteById(id);
	}

	@Override
	public List<Film> listAllFilms() {
		List<Film> liste = (List<Film>) filmDAO.findAll();
		return liste;
	}

}
