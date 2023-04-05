package data;

public abstract class Pet {
	protected String name;
	protected int yob;

	public Pet(String name, int yob) {
		this.name = name;
		this.yob = yob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYob() {
		return yob;
	}

	public void setYob(int yob) {
		this.yob = yob;
	}
	
	public abstract void eatFood();
	
}
