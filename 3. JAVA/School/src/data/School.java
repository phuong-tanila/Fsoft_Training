package data;

public class School {
	private String name;
	private String address;
	private String drum;
	
	public School(String name) {
		this.name = name;
	}
	
	public School(String name, String address) {
		this.address = address;
	}
	
	public School(String name, String address, String drum) {
		this.name = name;
		this.address = address;
		this.drum = drum;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDrum() {
		return drum;
	}
	public void setDrum(String drum) {
		this.drum = drum;
	}
}
