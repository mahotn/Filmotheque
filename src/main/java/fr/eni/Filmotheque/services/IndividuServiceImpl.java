package fr.eni.Filmotheque.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.Filmotheque.bo.Film;
import fr.eni.Filmotheque.bo.Individu;
import fr.eni.Filmotheque.dal.IndividuRepository;

@Service
public class IndividuServiceImpl implements IndividuService{
	private IndividuRepository individuDAO;
	
	public IndividuServiceImpl(IndividuRepository individuDAO) {
		this.individuDAO = individuDAO;
	}

	@Override
	public List<Individu> getIndividus() {
		List<Individu> individus = individuDAO.findAll();
		System.out.println("Individus dans serviceImpl"+individus);
		return individus;
	}

	@Override
	public List<Individu> findAllRealisateur() {
		List<Individu> listeRealisateurs = (List<Individu>) individuDAO.findAllRealisateur();
		System.out.println("Réalisateurs dans le service : "+listeRealisateurs.toString());
		return listeRealisateurs;
	}

}
