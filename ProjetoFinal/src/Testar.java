import javax.swing.JFrame;

public class Testar extends Layout {

	public static void main(String[] args) {
//		CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
//		CalculadoraMetabolica calculadoraMetabolica = new CalculadoraMetabolica();
//
//		IndividuoMasculino i1 = new IndividuoMasculino(52, 171, 21, NivelDeAtividadeFisica.MODERADA,
//				Objetivo.EMAGRECIMENTO);
//		IndividuoFeminino i2 = new IndividuoFeminino(72, 171, 21, NivelDeAtividadeFisica.MODERADA,
//				Objetivo.GANHO_MUSCULAR);
//
//		System.out.println(calculadoraIMC.getIMC(i1));
//		System.out.println(calculadoraIMC.getHealthCondition(i2).getSintomas());
//		System.out.println(NivelDeAtividadeFisica.LEVE);
//		System.out.println(NivelDeAtividadeFisica.LEVE.getFatorDeAtividade()[0]);
//		System.out.println(NivelDeAtividadeFisica.LEVE.getFatorDeAtividade()[1]);
//		System.out.println(calculadoraMetabolica.getTMB(i1));
//		System.out.println(calculadoraMetabolica.getNDC(i2));
//
//		IndividuoMasculino i3 = new IndividuoMasculino(102, 171, 21, NivelDeAtividadeFisica.MODERADA,
//				Objetivo.EMAGRECIMENTO);
//		System.out.println(calculadoraIMC.getHealthCondition(i3).getSintomas());
//		System.out.println(calculadoraIMC.getFaltaParaPesoSaudavel(i3));
//		System.out.println(calculadoraIMC.getSugestaoDePeso(i3));
//		System.out.println(calculadoraIMC.getSugestaoDePeso(i2));
//		System.out.println(calculadoraIMC.getSugestaoDePeso(i1));
//
//		System.out.println(ClassificacaoDePeso.ABAIXO_DO_PESO.getTituloDaClassificacao());

//		// aqui é o GUI
		Layout frame = new Layout();

		frame.setSize(1000, 500); // ele ta sendo ignorado pq ta em fullscreen
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // fullscreen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
