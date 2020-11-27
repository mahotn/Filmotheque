package fr.eni.Filmotheque.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.eni.Filmotheque.bo.Categorie;
import fr.eni.Filmotheque.bo.Film;

public interface FilmRepository extends JpaRepository<Film, Long>{
	@Query("SELECT f FROM Film f WHERE f.titre LIKE CONCAT('%', :title, '%')")
	List<Film> findByTitle(@Param("title") String title);
}