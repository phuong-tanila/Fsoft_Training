package fa.training.entities;

import javax.persistence.*;

@Entity
@Table(schema = "dbo", name = "MOVIE_TYPE")
public class MovieType {
	@Column(name = "MY_DESCRIPTION")
	private String myDescription;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Id
	@JoinColumn(name = "typeId", insertable = false, updatable = false)
	private Type type;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Id
	@JoinColumn(name = "movieId", insertable = false, updatable = false)
	private Movie movie;

	public MovieType() {
	}

	public MovieType(Integer typeId, String movieId, String myDescription, Type type, Movie movie) {
		super();
		this.myDescription = myDescription;
		this.type = type;
		this.movie = movie;
	}

	public String getMyDescription() {
		return myDescription;
	}

	public void setMyDescription(String myDescription) {
		this.myDescription = myDescription;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "MovieType [myDescription=" + myDescription + ", type=" + type + ", movie=" + movie + "]";
	}
}
