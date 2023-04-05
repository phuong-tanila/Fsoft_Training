package fa.training.entities;

import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table(name = "preferences")
public class Preferences {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "receive_news_letter")
	private boolean receiveNewsletter;
	private String[] interests;
	@Column(name = "favourite_word")
	private String favouriteWord;
	@Column(name = "gender")
	private String gender;
	@Column(name = "skill")
	private String skill;

	public Preferences() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isReceiveNewsletter() {
		return receiveNewsletter;
	}

	public void setReceiveNewsletter(boolean receiveNewsletter) {
		this.receiveNewsletter = receiveNewsletter;
	}

	public String[] getInterests() {
		return interests;
	}

	public void setInterests(String[] interests) {
		this.interests = interests;
	}

	public String getFavouriteWord() {
		return favouriteWord;
	}

	public void setFavouriteWord(String favouriteWord) {
		this.favouriteWord = favouriteWord;
	}
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Preferences [id=" + id + ", receiveNewsletter=" + receiveNewsletter + ", interests="
				+ Arrays.toString(interests) + ", favouriteWord=" + favouriteWord + "]";
	}

}