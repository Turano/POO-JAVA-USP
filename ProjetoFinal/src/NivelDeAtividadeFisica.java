
public enum NivelDeAtividadeFisica {
	// fator [0] -> constantes para individuos masculinos
	// fator [2] -> constantes para individuos femininos
	LEVE(new double[] {1.55, 1.56}), 
	MODERADA(new double[] {1.78, 1.64}),
	INTENSA(new double[] {2.10, 1.82});
	
	private double[] fatorDeAtividade = new double[2];
	// fator de atividade para consumo calórico [fator masculino, fator feminino]
	NivelDeAtividadeFisica(double[] fatorDeAtividade) {
		this.fatorDeAtividade = fatorDeAtividade;
	}
	
	public double[] getFatorDeAtividade() {
		return this.fatorDeAtividade;
	}
	
}
