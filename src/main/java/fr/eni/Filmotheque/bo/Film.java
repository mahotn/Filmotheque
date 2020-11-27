package fr.eni.Filmotheque.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String anneeSortie;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	private Categorie categorie;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="film", fetch = FetchType.EAGER)
	private List<Avis> listeAvis;
	
	public Film() {
		
	}
	
	// Constructeur avec attributs film.
	public Film(Long id, String titre, String anneeSortie) {
		super();
		this.id = id;
		this.titre = titre;
		this.anneeSortie = anneeSortie;
	}
	
	// Constructeur utilisant tous les attributs.
		public Film(Long id, String titre, String anneeSortie, Categorie categorie, List<Avis> listeAvis) {
			super();
			this.id = id;
			this.titre = titre;
			this.anneeSortie = anneeSortie;
			this.categorie = categorie;
			this.listeAvis = listeAvis;
		}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAnneeSortie() {
		return anneeSortie;
	}

	public void setAnneeSortie(String anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Avis> getListeAvis() {
		return listeAvis;
	}

	public void setListeAvis(List<Avis> listeAvis) {
		this.listeAvis = listeAvis;
	}

	// To String
	@Override
	public String toString() {
		return "[id=" + id + ", titre=" + titre + ", anneeSortie=" + anneeSortie + "]";
	}
	
	
	
}
