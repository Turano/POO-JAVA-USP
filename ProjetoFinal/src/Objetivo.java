
public enum Objetivo {
	EMAGRECIMENTO(0.8),
	GANHO_MUSCULAR(1.2),
	SAUDE(1.0);
	
	private double fatorDeObjetivo;

	Objetivo(double fatorDeObjetivo) {
		this.fatorDeObjetivo = fatorDeObjetivo;
	}
	
	public double getFatorDeOBjetivo() {
		return this.fatorDeObjetivo;
	}	
}
