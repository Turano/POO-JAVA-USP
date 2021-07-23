
public class CalculadoraMetabolica implements Metabolismo {

	@Override
	public double getTMB(Individuo individuo) {
		double tmb = 0;
		if (individuo instanceof IndividuoMasculino) {
			// TODO calcular formula masculina
		}else if (individuo instanceof IndividuoFeminino) {
			// TODO calcular formula feminina
		}
		return tmb;
	}

	@Override
	public double getNDC(Individuo individuo) {
		double tmb = this.getTMB(individuo);
		double ndc = tmb;
		if (individuo instanceof IndividuoMasculino) {
			// TODO calcular formula masculina
		}else if (individuo instanceof IndividuoFeminino) {
			// TODO calcular formula feminina
		}
		return ndc;
	}
	
}
