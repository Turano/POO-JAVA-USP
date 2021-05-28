
public class Bozo {
	public static void main(String[] args) {
		RolaDados dados1 = new RolaDados(5);
		
		int[] lados = dados1.rolar();
		for (int i = 0; i < lados.length; i++) {
			System.out.println(lados[i]);
		}		
		System.out.println(dados1);
		
		Placar placar = new Placar();
		System.out.println(placar);
		placar.add(3, lados);
		System.out.println(placar);
	}
}
