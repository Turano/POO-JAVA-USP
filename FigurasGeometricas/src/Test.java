
public class Test {
	public static void main(String[] args) {
		Figura[] figuras = {
				new Circle(3, "green"),
				new Circle(2.4, "red", true),
				new Rectangle(3, 4, "blue"),
				new Rectangle(3, 5, "pink", true),
				new Square(5, "black"),
				new Square(4, "orange", true)
		};
		
		System.out.println("--------------------DEMONSTRANDO FUNÇÕES--------------------");
		for (Figura figura : figuras) {
			System.out.println(figura);
		}
	}
}
