package data;

public class Guard implements Salary{
	private String name;
	private double workHour;

	public Guard(String name, double workHour) {
		this.name = name;
		this.workHour = workHour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWorkHour() {
		return workHour;
	}

	public void setWorkHour(double workHour) {
		this.workHour = workHour;
	}
	
	@Override
	public double calculateSalary() {
		return workHour * 100000;
	}
}
