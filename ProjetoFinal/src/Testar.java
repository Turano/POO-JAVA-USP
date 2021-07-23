
public class Testar {

	public static void main(String[] args) {
		CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
		System.out.println(calculadoraIMC
				.getIMC(new IndividuoMasculino(72, 171, 21, NivelDeAtividadeFisica.MODERADA)));
		System.out.println(calculadoraIMC
				.getHealthCondition(new IndividuoMasculino(72, 171, 21, NivelDeAtividadeFisica.MODERADA))
				.getSintomas());
		System.out.println(NivelDeAtividadeFisica.LEVE);
		System.out.println(NivelDeAtividadeFisica.LEVE.getFatorDeAtividade()[0]);
		System.out.println(NivelDeAtividadeFisica.LEVE.getFatorDeAtividade()[1]);
	}

}
