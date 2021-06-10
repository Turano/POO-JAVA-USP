
public class Bozo {
	public static void main(String[] args) {
		RolaDados rolaDados = new RolaDados(5);
		Placar placar = new Placar();
		String entradaUsuario;
		for (int i = 0; i < 10; i++) {
			System.out.println("Pressione ENTER para iniciar a rodada.");
			lerEnter();		
			int[] dados;
			dados = rolaDados.rolar();
			System.out.println(rolaDados);
			
			System.out.println("Quais dados gostaria de rolar novamente?");
			entradaUsuario = leDados();
			if(deveJogar(entradaUsuario)) {
				dados = rolaDados.rolar(entradaUsuario);				
			}
			System.out.println(rolaDados);
			
			System.out.println("Quais dados gostaria de rolar novamente?");
			entradaUsuario = leDados();
			if(deveJogar(entradaUsuario)) {
				dados = rolaDados.rolar(entradaUsuario);				
			}
			System.out.println(rolaDados);
			
			System.out.println(placar);
			
			System.out.println("Insira a posição do placar que gostaria de ocupar.");
			int posicao = 0;
			boolean leuUmInputAdequado = false;
			while(!leuUmInputAdequado) {
				leuUmInputAdequado = true;									
				try {
					posicao = lePosicao();					
					placar.add(posicao, dados);
				} catch (Exception e) {
					System.out.println("Posição inválida ou já ocupada, tente novamente.");
					leuUmInputAdequado=false;
				}
			}
			System.out.println(placar);
		}
			
		System.out.println("Pontuação final:");
		System.out.println(placar.getScore());	
	}
	
	public static void lerEnter() {
		String entradaUsuario;
		boolean leuUmInputAdequado = false;
		while(!leuUmInputAdequado) {
			try {
				entradaUsuario = EntradaTeclado.leString();
				if (entradaUsuario.equals("")) {
					leuUmInputAdequado = true;						
				}else {
					System.out.println("");
				}
			} catch (Exception e) {
				System.out.println("Entrada inválida, tente novamente.");
			}
		}
	}
	
	public static String leDados() {
		String entradaUsuario = "";
		boolean leuUmInputAdequado = false;
		while(!leuUmInputAdequado) {
			leuUmInputAdequado = true;									
			try {
				entradaUsuario = EntradaTeclado.leString();
			} catch (Exception e) {
				System.out.println("Entre valores válidos.");
				leuUmInputAdequado = false;
			}
		}
		return entradaUsuario;
	}
	
	public static boolean deveJogar(String dadosEscolhidos) {
		return !dadosEscolhidos.equals("");
	}
	
	public static int lePosicao() {
		int entradaUsuario = 0;
		boolean leuUmInputAdequado = false;
		while(!leuUmInputAdequado) {
			leuUmInputAdequado = true;									
			try {
				entradaUsuario = EntradaTeclado.leInt();
			} catch (Exception e) {
				System.out.println("Entre valores válidos (de 1 até 10).");
				leuUmInputAdequado = false;
			}
		}
		return entradaUsuario;
	}
	
}
