import java.util.stream.IntStream;

public class Placar {
	private int[] scores;
	private boolean[] posicaoEstaOcupada;
	private static int numberOfPositions = 10;
	private String[] posicoesDoPlacar = new String[] {
			"(1)", "(2)", "(3)", "(4)", "(5)", "(6)", "(7)", "(8)", "(9)","(10)",
	};
	
	public Placar() {
		scores = new int[numberOfPositions];
		posicaoEstaOcupada = new boolean[numberOfPositions];
	}
	
	public void add(int posicao, int[] dados) 
			throws java.lang.IllegalArgumentException {
		if(!ehUmaPosicaoValida(posicao) || posicaoEstaOcupada[posicao-1]) {
			throw new IllegalArgumentException();
		}else if (ehUmaJogadaSimples(posicao)){			
			scores[posicao-1] = IntStream.of(dados).filter(x->x == posicao).sum();
		} else if ((posicao == 7) && ehUmFullHand(dados)) {
			scores[posicao-1] = 15;
		} else if (posicao == 8 && ehUmaSequencia(dados)) {
			scores[posicao-1] = 20;
		} else if (posicao == 9 && ehUmaQuadra(dados)) {
			scores[posicao-1] = 30;
		} else if (posicao == 10 && ehUmaQuina(dados)) {
			scores[posicao-1] = 40;
		}
		posicaoEstaOcupada[posicao-1] = true;
		posicoesDoPlacar[posicao-1] = " "+String.valueOf(scores[posicao-1])+" ";
	}
	
	private boolean ehUmaPosicaoValida(int posicao) {
		return (posicao > 0 && posicao <= numberOfPositions);
	}
	
	private boolean ehUmaJogadaSimples(int posicao) {
		return (posicao > 0 && posicao <= 6);
	}
	
	private boolean ehUmFullHand(int[] dados) {
		int[] contaDados = contaDadosNaJogada(dados);
		boolean temTrinca = IntStream.of(contaDados).anyMatch(contador->contador == 3);
		boolean temDupla = IntStream.of(contaDados).anyMatch(contador->contador == 2);
		
		return (temTrinca && temDupla);
	}
	
	private int[] contaDadosNaJogada(int[] dados) {
		int[] contaDados = new int[6];
		for (int i = 0; i < dados.length; i++) {
			contaDados[dados[i]-1]++;
		}
		return contaDados;
	}
	
	private boolean ehUmaSequencia(int[] dados) {
		return (ehUmaSequencia1a5(dados) || ehUmaSequencia2a6(dados));
	}
	
	private boolean ehUmaSequencia1a5(int[] dados) {
		int[] contaDados = new int[6];
		return !faltaElementoNaSequencia(contaDados, 0, contaDados.length - 1);
	}
	
	private boolean ehUmaSequencia2a6(int[] dados) {
		int[] contaDados = new int[6];
		return !faltaElementoNaSequencia(contaDados, 1, contaDados.length);
	}
	
	private boolean faltaElementoNaSequencia(int[] contaDados, int limiteInferior, int limiteSuperior) {
		for (int i = limiteInferior; i < limiteSuperior; i++) {
			if(contaDados[i] != 1) {
				return true;
			}
		}
		return false;
	}
	
	private boolean ehUmaQuadra(int[] dados) {
		int[] contaDados = contaDadosNaJogada(dados);
		return IntStream.of(contaDados).anyMatch(contador->contador == 4);
	}
	
	private boolean ehUmaQuina(int[] dados) {
		int[] contaDados = contaDadosNaJogada(dados);
		return IntStream.of(contaDados).anyMatch(contador->contador == 5);
	}
	
	
	public int getScore() {
		return IntStream.of(scores).sum();
	}
	
	@Override
	public String toString() {
		String placar = "";
		for (int i = 0; i < 3; i++) {
			placar += posicoesDoPlacar[i]
					+ "    |   "
					+ posicoesDoPlacar[i+6]
					+ "    |   "
					+ posicoesDoPlacar[i+3]
					+ "\n"
					+ "--------------------------\n";
		}
		placar += "       |   "
				+ posicoesDoPlacar[9]
				+ "   |       \n"
				+ "       +----------+       \n";
		
		return placar;
	}
}
