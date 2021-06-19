
public class Rectangle extends Figura {

	protected double height;
	protected double width;

	public Rectangle(double height, double width, String color) {
		super(color);
		this.height = height;
		this.width = width;
	}	

	public Rectangle(double height, double width, String color, boolean filled) {
		super(color, filled);
		this.height = height;
		this.width = width;
	}

	double getArea() {
		return this.height*this.width;
	}

	double getPerimeter() {
		return 2*(this.height + this.width);
	}

}
