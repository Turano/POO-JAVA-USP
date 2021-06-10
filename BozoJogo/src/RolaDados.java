
public class RolaDados {

	private Dado[] dados;
	private int numeroDeDados;
	
	public RolaDados(int n) {
		setNumeroDeDados(n);
		dados = new Dado[n];
		for (int i = 0; i < n; i++) {
			dados[i] = new Dado();			
		}
	}
	
	public int getNumeroDeDados() {
		return numeroDeDados;
	}
	
	public void setNumeroDeDados(int numeroDeDados) {
		this.numeroDeDados = numeroDeDados;
	}
	
	public int[] rolar() {
		int[] lados = new int[numeroDeDados];
		for (int i = 0; i < lados.length; i++) {
			lados[i] = dados[i].rolar();
		}
		return lados;
	}
	
	public int[] rolar(boolean[] quais) {
		int[] lados = new int[numeroDeDados];
		for (int i = 0; i < lados.length; i++) {
			if(quais[i]) {
				lados[i] = dados[i].rolar();				
			} else {
				lados[i] = dados[i].getLado();
			}
		}
		return lados;
	}
	
	public int[] rolar(String s) {
		String[] dadosEscolhidos = s.split(" ");
		
		boolean[] quais = new boolean[numeroDeDados];
		
		for (int i = 0; i < dadosEscolhidos.length; i++) {
			int dadoEscolhido = Integer.parseInt(dadosEscolhidos[i]);
			if( dadoEscolhido>0 && dadoEscolhido <= numeroDeDados) {
				quais[dadoEscolhido-1] = true;
			}
		}
		return rolar(quais);
	}
	
	@Override
	public String toString() {
		String resultado = "";
		String[][] ladosDosDados = new String[numeroDeDados][5]; // cada lado é formado por 5 linhas
		for (int i = 0; i < numeroDeDados; i++) {
			ladosDosDados[i] = dados[i].toString().split("\n"); // quebra de linha retirada
		}
		
		// construção da nova matriz de dados alinhados
		for (int i = 0; i < numeroDeDados; i++) {
			for (int j = 0; j < 5; j++) {
				resultado += ladosDosDados[j][i];				
			}
			resultado += "\n";
		}
		
		return resultado;
	}
	
}
