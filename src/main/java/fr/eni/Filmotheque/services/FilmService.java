package fr.eni.Filmotheque.services;

import java.util.List;

import fr.eni.Filmotheque.bo.Film;

public interface FilmService {
	List<Film> listAllFilms();
	void addFilm(Film film);
	void deleteFilm(Long id);
}
