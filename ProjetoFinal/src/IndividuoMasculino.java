
public class IndividuoMasculino extends Individuo {

	CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
	CalculadoraMetabolica calculadoraMetabolica = new CalculadoraMetabolica();
	
	public IndividuoMasculino(double peso, double altura, int idade, NivelDeAtividadeFisica nivelDeAtividadeFisica) {
		super(peso, altura, idade, nivelDeAtividadeFisica);
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
