package fa.training.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(schema = "dbo", name = "TYPE")
public class Type {
	@Id
	@Column(name = "TYPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer typeId;

	@Column(name = "TYPE_NAME")
	private String typeName;

	@Column(name = "TYPE_DESCRIPTION")
	private String typeDescription;

	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
	private Set<MovieType> movieType;

	public Type() {
	}

	public Type(Integer typeId, String typeName, String typeDescription, Set<MovieType> movieType) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeDescription = typeDescription;
		this.movieType = movieType;
	}

	public Type(String typeName, String typeDescription) {
		super();
		this.typeName = typeName;
		this.typeDescription = typeDescription;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

	public Set<MovieType> getMovieType() {
		return movieType;
	}

	public void setMovieType(Set<MovieType> movieType) {
		this.movieType = movieType;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeName=" + typeName + ", typeDescription=" + typeDescription
				+ ", movieType=" + movieType + "]";
	}
}
