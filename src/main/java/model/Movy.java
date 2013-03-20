package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the movies database table.
 * 
 */
@Entity
@Table(name="movies")
public class Movy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tmsId;

	private String descriptionLang;

	private String entityType;

	private int id;

	private byte loaded;

	private String longDescription;

	private BigInteger releaseYear;

	private String rootId;

	private String runTime;

	private String shortDescription;

	private String title;

	//bi-directional many-to-one association to Cast
	@OneToMany(mappedBy="movy")
	private List<Cast> casts;

	//bi-directional many-to-one association to Crew
	@OneToMany(mappedBy="movy")
	private List<Crew> crews;

	//bi-directional many-to-one association to Keyword
	@OneToMany(mappedBy="movy")
	private List<Keyword> keywords;

	//bi-directional many-to-many association to Genre
	@ManyToMany
	@JoinTable(
		name="movies_genre"
		, joinColumns={
			@JoinColumn(name="movies_tmsId",updatable=false,insertable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="genres_genre",updatable=false,insertable=false)
			}
		)
	private List<Genre> genres;

	//bi-directional many-to-many association to Image
	@ManyToMany
	@JoinTable(
		name="movies_image"
		, joinColumns={
			@JoinColumn(name="movies_tmsId",updatable=false,insertable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="image_imageId",updatable=false,insertable=false)
			}
		)
	private List<Image> images;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="movy")
	private List<Rating> ratings;

	public Movy() {
	}

	public String getTmsId() {
		return this.tmsId;
	}

	public void setTmsId(String tmsId) {
		this.tmsId = tmsId;
	}

	public String getDescriptionLang() {
		return this.descriptionLang;
	}

	public void setDescriptionLang(String descriptionLang) {
		this.descriptionLang = descriptionLang;
	}

	public String getEntityType() {
		return this.entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getLoaded() {
		return this.loaded;
	}

	public void setLoaded(byte loaded) {
		this.loaded = loaded;
	}

	public String getLongDescription() {
		return this.longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public BigInteger getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(BigInteger releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getRootId() {
		return this.rootId;
	}

	public void setRootId(String rootId) {
		this.rootId = rootId;
	}

	public String getRunTime() {
		return this.runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Cast> getCasts() {
		return this.casts;
	}

	public void setCasts(List<Cast> casts) {
		this.casts = casts;
	}

	public Cast addCast(Cast cast) {
		getCasts().add(cast);
		cast.setMovy(this);

		return cast;
	}

	public Cast removeCast(Cast cast) {
		getCasts().remove(cast);
		cast.setMovy(null);

		return cast;
	}

	public List<Crew> getCrews() {
		return this.crews;
	}

	public void setCrews(List<Crew> crews) {
		this.crews = crews;
	}

	public Crew addCrew(Crew crew) {
		getCrews().add(crew);
		crew.setMovy(this);

		return crew;
	}

	public Crew removeCrew(Crew crew) {
		getCrews().remove(crew);
		crew.setMovy(null);

		return crew;
	}

	public List<Keyword> getKeywords() {
		return this.keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}

	public Keyword addKeyword(Keyword keyword) {
		getKeywords().add(keyword);
		keyword.setMovy(this);

		return keyword;
	}

	public Keyword removeKeyword(Keyword keyword) {
		getKeywords().remove(keyword);
		keyword.setMovy(null);

		return keyword;
	}

	public List<Genre> getGenres() {
		return this.genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Rating addRating(Rating rating) {
		getRatings().add(rating);
		rating.setMovy(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setMovy(null);

		return rating;
	}

}