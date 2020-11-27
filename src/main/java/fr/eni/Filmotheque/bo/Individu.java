package fr.eni.Filmotheque.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Individu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="realisateur", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Film> listeFilmsRealisateur;
//	@ManyToMany (mappedBy = "individu")
//	private List<Film> listeFilmsActeurs;

	public Individu(Long id, String nom, String prenom, List<Film> listeFilmsRealisateur
//			, List<Film> listeFilmsActeurs
			) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.listeFilmsRealisateur = listeFilmsRealisateur;
//		this.listeFilmsActeurs = listeFilmsActeurs;
	}
	
	public Individu() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Film> getListeFilmsRealisateur() {
		return listeFilmsRealisateur;
	}

	public void setListeFilmsRealisateur(List<Film> listeFilmsRealisateur) {
		this.listeFilmsRealisateur = listeFilmsRealisateur;
	}

	
	
//	public List<Film> getListeFilmsActeurs() {
//		return listeFilmsActeurs;
//	}
//
//	public void setListeFilmsActeurs(List<Film> listeFilmsActeurs) {
//		this.listeFilmsActeurs = listeFilmsActeurs;
//	}

	@Override
	public String toString() {
		return "Individu [id=" + id + ", nom=" + nom + ", prenom=" + prenom 
//				+ ", listeFilmsRealisateur=" + listeFilmsRealisateur
//				+ ", listeFilmsActeurs=" + listeFilmsActeurs 
				+ "]";
	}


	
}
