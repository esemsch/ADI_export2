package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int imageId;

	private String caption;

	private String category;

	private int height;

	private String lang;

	private Byte loaded;

	private Byte primaryImage;

	private String uri;

	private int width;

	//bi-directional many-to-many association to Movy
	@ManyToMany(mappedBy="images")
	private List<Movy> movies;

	public Image() {
	}

	public int getImageId() {
		return this.imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getCaption() {
		return this.caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Byte getLoaded() {
		return this.loaded;
	}

	public void setLoaded(Byte loaded) {
		this.loaded = loaded;
	}

	public Byte getPrimaryImage() {
		return this.primaryImage;
	}

	public void setPrimaryImage(Byte primaryImage) {
		this.primaryImage = primaryImage;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<Movy> getMovies() {
		return this.movies;
	}

	public void setMovies(List<Movy> movies) {
		this.movies = movies;
	}

}