package fr.eni.Filmotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.Filmotheque.bo.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
