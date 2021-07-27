
public class IndividuoFeminino extends Individuo {

	CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
	CalculadoraMetabolica calculadoraMetabolica = new CalculadoraMetabolica();
	
	public IndividuoFeminino(
			double peso, 
			double altura, 
			int idade, 
			NivelDeAtividadeFisica nivelDeAtivFis, 
			Objetivo objetivoPessoal) {
		super(peso, altura, idade, nivelDeAtivFis, objetivoPessoal);
	}

	@Override
	double getIMC() {
		return calculadoraIMC.getIMC(this);
	}

	@Override
	double getTMB() {
		return calculadoraMetabolica.getTMB(this);
	}

	@Override
	double getNDC() {
		return calculadoraMetabolica.getNDC(this);
	}

}
