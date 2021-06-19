
public abstract class Figura {
	protected String color;
	protected boolean filled;

	public Figura(String color) {
		super();
		this.color = color;
		this.filled = false;
	}
	
	public Figura(String color, boolean filled) {
		super();
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	abstract double getArea();
	abstract double getPerimeter();
	
	@Override
	public String toString() {
		return "Color: " + this.color +"\n"
		+"Filled: " + this.filled + "\n"
		+"Area: " + String.format("%.2f", this.getArea()) + "\n"
		+"Perimeter: " + String.format("%.2f", this.getPerimeter()) + "\n";
	}
}
