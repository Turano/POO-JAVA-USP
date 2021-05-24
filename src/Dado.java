
public class Dado {

	private int numeroDeLados;
	private int lado;
	private static Random randomNumberGenerator = new Random();
	
	public Dado() {
		numeroDeLados = 6;
	}
	
	public Dado(int n) {
		numeroDeLados = n;
	}
	
	public int getLado() {
		return lado;
	}
	
	public int rolar() {
		lado = randomNumberGenerator.getIntRand(numeroDeLados) + 1;
		return lado;
	}
	
	@Override
	public String toString() {
		String resultado = "";
		switch (lado) {
			case 1:
				resultado = (
					  "+-----+	\n"
					+ "|     |	\n"
					+ "|  *  |	\n"
					+ "|     |	\n"
					+ "+-----+	\n"
				);					 
				break;
			case 2:
				resultado = (
					  "+-----+	\n"
					+ "|*    |	\n"
					+ "|     |	\n"
					+ "|    *|	\n"
					+ "+-----+	\n"
				);					 
				break;
			case 3:
				resultado = (
					  "+-----+	\n"
					+ "|*    |	\n"
					+ "|  *  |	\n"
					+ "|    *|	\n"
					+ "+-----+	\n"
				);					 
				break;
		
			case 4:
				resultado = (
					  "+-----+	\n"
					+ "|*   *|	\n"
					+ "|     |	\n"
					+ "|*   *|	\n"
					+ "+-----+	\n"
				);					 
				break;
		
			case 5:
				resultado = (
					  "+-----+	\n"
					+ "|*   *|	\n"
					+ "|  *  |	\n"
					+ "|*   *|	\n"
					+ "+-----+	\n"
				);					 
				break;
		
			case 6:
				resultado = (
					  "+-----+	\n"
					+ "|*   *|	\n"
					+ "|*   *|	\n"
					+ "|*   *|	\n"
					+ "+-----+	\n"
				);					 
				break;
		
			default:
				break;
		}
		return resultado;
	}
}
