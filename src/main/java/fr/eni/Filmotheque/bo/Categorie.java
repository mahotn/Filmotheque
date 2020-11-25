package fr.eni.Filmotheque.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="categorie", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Film> listeFilms;
	
	public Categorie() {
		
	}
	
	// Constructeur
	public Categorie(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public List<Film> getListeFilms() {
		return listeFilms;
	}

	public void setListeFilms(List<Film> listeFilms) {
		this.listeFilms = listeFilms;
	}

	// To String
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
	
}
