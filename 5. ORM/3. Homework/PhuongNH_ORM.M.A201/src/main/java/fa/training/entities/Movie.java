package fa.training.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(schema = "dbo", name = "MOVIE")
public class Movie {
	@Id
	@Column(name = "MOVIE_ID")
	private String movieId;

	@Column(name = "ACTOR")
	private String actor;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "DIRECTOR")
	private String director;

	@Column(name = "DURATION")
	private Double duration;

	@Column(name = "FROM_DATE")
	private LocalDate fromDate;

	@Column(name = "TO_DATE")
	private LocalDate toDate;

	@Column(name = "MOVIE_PRODUCTION_COMPANY")
	private String movieProductionCompany;

	@Column(name = "VERSION")
	private String version;

	@Column(name = "MOVIE_NAME_ENG")
	private String movieNameEng;

	@Column(name = "MOVIE_NAME_VN")
	private String movieNameVn;

	@Column(name = "LARGE_IMAGE")
	private String largeImage;

	@Column(name = "SMALL_IMAGE")
	private String smallImage;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<MovieType> movieType;

	public Movie() {
	}

	public Movie(String movieId, String actor, String content, String director, Double duration, LocalDate fromDate,
			LocalDate toDate, String movieProductionCompany, String version, String movieNameEng, String movieNameVn,
			String largeImage, String smallImage, Set<MovieType> movieType) {
		super();
		this.movieId = movieId;
		this.actor = actor;
		this.content = content;
		this.director = director;
		this.duration = duration;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.movieProductionCompany = movieProductionCompany;
		this.version = version;
		this.movieNameEng = movieNameEng;
		this.movieNameVn = movieNameVn;
		this.largeImage = largeImage;
		this.smallImage = smallImage;
		this.movieType = movieType;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getMovieProductionCompany() {
		return movieProductionCompany;
	}

	public void setMovieProductionCompany(String movieProductionCompany) {
		this.movieProductionCompany = movieProductionCompany;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMovieNameEng() {
		return movieNameEng;
	}

	public void setMovieNameEng(String movieNameEng) {
		this.movieNameEng = movieNameEng;
	}

	public String getMovieNameVn() {
		return movieNameVn;
	}

	public void setMovieNameVn(String movieNameVn) {
		this.movieNameVn = movieNameVn;
	}

	public String getLargeImage() {
		return largeImage;
	}

	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public Set<MovieType> getMovieType() {
		return movieType;
	}

	public void setMovieType(Set<MovieType> movieType) {
		this.movieType = movieType;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", actor=" + actor + ", content=" + content + ", director=" + director
				+ ", duration=" + duration + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", movieProductionCompany=" + movieProductionCompany + ", version=" + version + ", movieNameEng="
				+ movieNameEng + ", movieNameVn=" + movieNameVn + ", largeImage=" + largeImage + ", smallImage="
				+ smallImage + ", movieType=" + movieType + "]";
	}
}