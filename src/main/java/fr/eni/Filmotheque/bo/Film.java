package fr.eni.Filmotheque.bo;

import java.util.Date;

public class Film {
	private int id;
	private String titre;
	// Objet date issu du package java.sql qui n'encapsule que la date sans la partie horaire.
	private Date anneeSortie;
	
	// Constructeur utilisant tous les attributs.
	public Film(int id, String titre, Date anneeSortie) {
		super();
		this.id = id;
		this.titre = titre;
		this.anneeSortie = anneeSortie;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getAnneeSortie() {
		return anneeSortie;
	}

	public void setAnneeSortie(Date anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	// To String
	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", anneeSortie=" + anneeSortie + "]";
	}
	
	
	
}
