package fr.eni.Filmotheque.services;

import java.util.List;
import java.util.Optional;

import fr.eni.Filmotheque.bo.Categorie;
import fr.eni.Filmotheque.bo.Film;

public interface FilmService {
	List<Film> listAllFilms();
	void addFilm(Film film);
	void editFilm(Film film);
	void deleteFilm(Long id);
	List<Film> findFilmByTitle(String name);
	Film findFilmDetails(Long id);
}
