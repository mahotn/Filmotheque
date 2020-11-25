package fr.eni.Filmotheque.bo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avis implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String contenu;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	private Film film;
	
	public Avis() {
		super();
	}
	
	public Avis(Long id, String contenu, Film film) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.film = film;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Avis [id=" + id + ", contenu=" + contenu + ", film=" + film + "]";
	}
	
}
