
public interface IMC {
	double getIMC(Individuo individuo);
	public double getFaltaParaPesoSaudavel(Individuo individuo);
	public String getSugestaoDePeso(Individuo individuo);
	ClassificacaoDePeso getHealthCondition(Individuo individuo);
}
