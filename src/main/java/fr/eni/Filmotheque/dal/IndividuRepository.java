package fr.eni.Filmotheque.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.eni.Filmotheque.bo.Film;
import fr.eni.Filmotheque.bo.Individu;

public interface IndividuRepository extends JpaRepository<Individu, Long>{
	@Query(value="SELECT distinct * from individu where individu.id in (SELECT distinct film.realisateur_id from film)", 
			  nativeQuery = true)
	List<Individu> findAllRealisateur();

}
