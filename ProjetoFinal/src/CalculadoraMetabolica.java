
public class CalculadoraMetabolica implements Metabolismo {

	@Override
	public double getTMB(Individuo individuo) {
		double tmb = 0;
		if (individuo instanceof IndividuoMasculino) {
			tmb = (66 + 13.7*individuo.getPeso() + 5*individuo.getAltura() - 6.8*individuo.getIdade());
		}else if (individuo instanceof IndividuoFeminino) {
			tmb = 665 + 9.6*individuo.getPeso() + 1.8*individuo.getAltura() - 4.7*individuo.getIdade();
		}
		return tmb;
	}

	@Override
	public double getNDC(Individuo individuo) {
		double tmb = this.getTMB(individuo);
		double ndc = 0;
		double fatorDeObjetivoPessoal = individuo.getObjetivoPessoal().getFatorDeOBjetivo();

		if (individuo instanceof IndividuoMasculino) {
			double fatorDeAtividadeFisica = individuo.getNivelDeAtividadeFisica().getFatorDeAtividade()[0];
			ndc = tmb*fatorDeAtividadeFisica*fatorDeObjetivoPessoal;
		}else if (individuo instanceof IndividuoFeminino) {
			double fatorDeAtividadeFisica = individuo.getNivelDeAtividadeFisica().getFatorDeAtividade()[1];
			ndc = tmb*fatorDeAtividadeFisica*fatorDeObjetivoPessoal;
		}
		return ndc;
	}
	
}
