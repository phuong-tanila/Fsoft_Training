package data;

import java.io.*;

public class StudentService {

	public boolean write(Student student) throws FileNotFoundException, IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.txt"))) {
			oos.writeObject(student);
		}
		return true;
	}

	public Student read() throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"))) {
			Student student = (Student) ois.readObject(); // Upcasting
			return student;
		}
	}
}
