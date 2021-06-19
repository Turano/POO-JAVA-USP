
public class Circle extends Figura {
	private double pi = Math.PI;
	private double radius;
	
	public Circle(double radious, String color) {
		super(color);
		this.radius = radious;
	}

	public Circle(double radious, String color, boolean filled) {
		super(color, filled);
		this.radius = radious;
	}

	double getArea() {
		return this.pi*this.radius*this.radius;
	}

	double getPerimeter() {
		return 2*this.pi*this.radius;
	}
}
