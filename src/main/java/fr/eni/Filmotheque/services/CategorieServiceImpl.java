package fr.eni.Filmotheque.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.Filmotheque.bo.Categorie;
import fr.eni.Filmotheque.dal.CategorieRepository;

@Service
public class CategorieServiceImpl implements CategorieService{
	private CategorieRepository categorieDAO;
	
	public CategorieServiceImpl(CategorieRepository categorieDAO) {
		this.categorieDAO = categorieDAO;
	}

	@Override
	public List<Categorie> getCategories() {
		List<Categorie> categories = categorieDAO.findAll();
		return categories;
	}

}
