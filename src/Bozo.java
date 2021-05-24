
public class Bozo {
	public static void main(String[] args) {
		RolaDados dados1 = new RolaDados(5);
		
		int[] lados = dados1.rolar();
		for (int i = 0; i < lados.length; i++) {
			System.out.println(lados[i]);
		}		
		System.out.println(dados1);
		
		boolean[] quais = new boolean[] {true, false, true, false, false};
		lados = dados1.rolar(quais);
		for (int i = 0; i < lados.length; i++) {
			System.out.println(lados[i]);
		}		
		System.out.println(dados1);
		
		lados = dados1.rolar("1 4 5");
		for (int i = 0; i < lados.length; i++) {
			System.out.println(lados[i]);
		}		
		System.out.println(dados1);
		
		lados = dados1.rolar("1 4 6");
		for (int i = 0; i < lados.length; i++) {
			System.out.println(lados[i]);
		}		
		System.out.println(dados1);
	}
}
