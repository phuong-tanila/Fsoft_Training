package studentmanagement;

public class Teacher {
	private String name;
	private int age;
	private String subject;
	
	public Teacher(String name, int age, String subject) {
		this.name = name;
		this.age = age;
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void Show() {
		System.out.printf("Tên: %15s | Tuổi: %d | Môn dạy: %2s\n", name, age, subject);
	}
}
