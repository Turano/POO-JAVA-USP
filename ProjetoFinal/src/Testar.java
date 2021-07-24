
public class Testar {

	public static void main(String[] args) {
		CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
		CalculadoraMetabolica calculadoraMetabolica = new CalculadoraMetabolica();
		
		IndividuoMasculino i1 = new IndividuoMasculino(72, 171, 21, NivelDeAtividadeFisica.MODERADA);
		IndividuoFeminino i2 = new IndividuoFeminino(72, 171, 21, NivelDeAtividadeFisica.MODERADA);
		
		System.out.println(calculadoraIMC.getIMC(i1));
		System.out.println(calculadoraIMC.getHealthCondition(i2));
		System.out.println(NivelDeAtividadeFisica.LEVE);
		System.out.println(NivelDeAtividadeFisica.LEVE.getFatorDeAtividade()[0]);
		System.out.println(NivelDeAtividadeFisica.LEVE.getFatorDeAtividade()[1]);
		System.out.println(calculadoraMetabolica.getTMB(i1));
		System.out.println(calculadoraMetabolica.getNDC(i2));
	}

}
