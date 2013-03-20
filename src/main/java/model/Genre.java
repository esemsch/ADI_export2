package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genre database table.
 * 
 */
@Entity
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String genre;

	private int id;

	//bi-directional many-to-many association to Movy
	@ManyToMany(mappedBy="genres")
	private List<Movy> movies;

	public Genre() {
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Movy> getMovies() {
		return this.movies;
	}

	public void setMovies(List<Movy> movies) {
		this.movies = movies;
	}

}