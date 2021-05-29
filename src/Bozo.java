import java.io.IOException;

public class Bozo {
	public static void main(String[] args) {
		
		Placar placarCorreto1 = new Placar();
		Placar placarCorreto2 = new Placar();
		Placar placarErrado = new Placar();
		
		int[] dados = new int[] {2, 2, 3, 3, 3};
		placarCorreto1.add(7, dados);
		dados = new int[] {2, 3, 2, 3, 3};
		placarCorreto2.add(7, dados);
		dados = new int[] {1, 1, 1, 1, 1};
		placarErrado.add(7, dados);
		
		dados = new int[] {1, 2, 3, 4, 5};
		placarCorreto1.add(8, dados);
		dados = new int[] {2, 3, 4, 5, 6};
		placarCorreto2.add(8, dados);
		dados = new int[] {2, 3, 4, 5, 5};
		placarErrado.add(8, dados);
		
		dados = new int[] {1, 1, 1, 4, 1};
		placarCorreto1.add(9, dados);
		dados = new int[] {1, 1, 3, 1, 1};
		placarCorreto2.add(9, dados);
		dados = new int[] {3, 3, 3, 5, 5};
		placarErrado.add(9, dados);
		
	
		dados = new int[] {1, 1, 1, 1, 1};
		placarCorreto1.add(10, dados);
		dados = new int[] {3, 3, 3, 5, 5};
		placarErrado.add(10, dados);
		
		
		System.out.println(placarCorreto1);
		System.out.println(placarCorreto2);
		System.out.println(placarErrado);			
	}
}
