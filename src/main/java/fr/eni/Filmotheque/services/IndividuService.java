package fr.eni.Filmotheque.services;

import java.util.List;

import fr.eni.Filmotheque.bo.Individu;

public interface IndividuService {
	List<Individu> getIndividus();
	List<Individu> findAllRealisateur();
}
