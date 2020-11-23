package fr.eni.Filmotheque.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titre;
	// Objet date issu du package java.sql qui n'encapsule que la date sans la partie horaire.
	private String anneeSortie;
	
	public Film() {
		
	}
	
	// Constructeur utilisant tous les attributs.
	public Film(Long id, String titre, String anneeSortie) {
		super();
		this.id = id;
		this.titre = titre;
		this.anneeSortie = anneeSortie;
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

	// To String
	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", anneeSortie=" + anneeSortie + "]";
	}
	
	
	
}
