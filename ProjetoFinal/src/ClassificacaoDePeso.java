
public enum ClassificacaoDePeso {
	ABAIXO_DO_PESO(new String[] { "Abaixo do peso.", "Se manter em um estado de peso muito baixo pode acarretar sintomas como "
			+ "queda de cabelo, infertilidade, ausencia menstrual, fadiga, stres e ansiedade"}), 
	NORMAL(new String[] {"Peso adequado.", "Menor risco de doencas cardaacas e vasculares."}), 
	SOBREPESO(new String[] {"Sobrepeso.", "Estar em sobrepeso pode ocasionar sintomas como fadiga, ma circulacao, varizes"}),
	OBESIDADE_GRAU1(new String[] {"Obesidade de grau 1.", "O estado de obesidade esta intimimamente associado como fator de risco para doencas como"
			+ " diabetes, angina, infarto, aterosclerose."}),
	OBESIDADE_GRAU2(new String[] {"Obesidade de grau 2.", "O estado de obesidade esta intimimamente associado como fator de risco para"
			+ " doencas vasculares e cardiacas alem de outras como apneia do sono, falta de ar."}), 
	OBESIDADE_GRAU3(new String[] {"Obesidade de grau 3.", "O estado de obesidade esta intimimamente associado como fator de risco para "
			+ "doencas vasculares e cardiacas como diabetes, infarto, AVC e além delas outras como"
			+ " refluxo, dificuldade para se mover, escaras."});
	
	private String[] classificacao;
	
	ClassificacaoDePeso(String [] classificacao) {
		this.classificacao = classificacao;
	}

	public String getTituloDaClassificacao() {
		return this.classificacao[0];
	}
	public String getSintomas() {
		return this.classificacao[1];
	}
}
