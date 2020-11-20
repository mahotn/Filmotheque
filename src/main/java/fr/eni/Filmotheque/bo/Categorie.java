package fr.eni.Filmotheque.bo;

public class Categorie {
	private int id;
	private String libelle;
	
	// Constructeur
	public Categorie(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	// To String
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
	
}
