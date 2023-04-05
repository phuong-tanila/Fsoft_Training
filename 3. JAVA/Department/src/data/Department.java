package data;

public class Department {
	
	public static void main(String[] args) {

	}
	
	public double getBonus(double saleMoney) {
		if(saleMoney > 5000) {
			return (saleMoney * 5) / 100;
		}
		return 0;
	}
	
	public int getBonus(int unit) {
		if(unit > 25) {
			return unit * 150;
		}
		if(0 < unit && unit < 25) {
			return unit * 100;
		}
		return 0;
	}
	
	public int getBonus(String kindEmployee, int parts) {
		if(kindEmployee.equalsIgnoreCase("Part-time")) {
			if(parts >= 250)
				return parts * 10;
		}else {
			if(parts >= 700) {
				return parts * 700;
			}
		}
		return 0;
	}
}
