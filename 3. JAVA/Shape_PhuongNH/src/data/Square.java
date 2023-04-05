package data;

public class Square extends Shape{

	private double edge;
	
	public Square(String color) {
		super(color);
	}

	public Square(String color, double edge) {
		super(color);
		this.edge = edge;
	}

	public double getEdge() {
		return edge;
	}

	public void setEdge(double edge) {
		this.edge = edge;
	}

	@Override
	public double calculatePerimeter() {
		return edge * 4;
	}

	@Override
	public double calculateArea() {
		return edge * edge;
	}
	
	public void showColor() {
		System.out.printf("\nSquare is %5s\n", getColor());
	}
	
}
