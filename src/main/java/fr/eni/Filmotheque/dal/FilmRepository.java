package fr.eni.Filmotheque.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.Filmotheque.bo.Film;

public interface FilmRepository extends CrudRepository<Film, Long>{

}
