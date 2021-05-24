
public class Bozo {
	public static void main(String[] args) {
		Dado d1 = new Dado();
		
		for (int i = 0; i < 50; i++) {
			d1.rolar();
			System.out.println("Lado " + d1.getLado());
			System.out.println(d1);
		}
	}
}
