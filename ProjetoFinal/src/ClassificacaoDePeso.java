
public enum ClassificacaoDePeso {
	ABAIXO_DO_PESO("Se manter em um estado de peso muito baixo pode acarretar sintomas como "
			+ "queda de cabelo, infertilidade, ausência menstrual, fadiga, stres e ansiedade"), 
	NORMAL("Menor risco de doenças cardíacas e vasculares."), 
	SOBREPESO("Estar em sobrepeso pode ocasionar sintomas como fadiga, má circulação, varizes"),
	OBESIDADE_GRAU1("O estado de obesidade esta intimimamente associado como fator de risco para doenças como"
			+ " diabetes, angina, infarto, aterosclerose."),
	OBESIDADE_GRAU2("O estado de obesidade esta intimimamente associado como fator de risco para"
			+ " doenças vasculares e cardíacas além de outras como apneia do sono, falta de ar"), 
	OBESIDADE_GRAU3("O estado de obesidade esta intimimamente associado como fator de risco para "
			+ "doenças vasculares e cardíacas como diabetes, infarto, AVC e além delas outras como"
			+ " refluxo, dificuldade para se mover, escaras.");
	
	private String sintomas;
	
	ClassificacaoDePeso(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getSintomas() {
		return this.sintomas;
	}
}
