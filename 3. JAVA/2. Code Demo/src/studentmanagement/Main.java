package studentmanagement;

public class Main {
	public static void main(String[] args) {
		Teacher t1 = new Teacher("Thầy giáo Ba", 33, "Susan 0175");
		Teacher t2 = new Teacher("SuTV", 69, "CSD All Level");
		Teacher t3 = new Teacher("HoaDNT", 32, "PRO192");
		Teacher t4 = new Teacher("HoangNT2", 47, "Bao show");
		Teacher t5 = new Teacher("AnNTK", 29, "MAS");
		
		String[] arr = {t1.getName(), t2.getName(), t3.getName()};
		for (String o : arr) {
			System.out.println(o);
		}
		
		
		
		t1.Show();
		t2.Show();
		t3.Show();
		t4.Show();
		t5.Show();
		
		t1.setSubject("thầy đó thầy đó mấy em");
		t1.Show();
	}
}
