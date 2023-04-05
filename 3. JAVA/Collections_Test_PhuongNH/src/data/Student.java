package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student {
	private List<String> list;
	private String name;
	private Map<String, Integer> mark;
	
	public Student() {
		list = new ArrayList<>();
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Map<String, Integer> getMark() {
		return mark;
	}

	public void setMark(Map<String, Integer> mark) {
		this.mark = mark;
	}
	
	public void addSubject(String string) {
		this.list.add(string);
	}

	public void showSubject() {
		for (String s : list) {
			System.out.print(s + " ");
		}
	}
}