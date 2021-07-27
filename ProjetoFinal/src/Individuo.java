
public abstract class Individuo {
	protected double peso;
	protected double altura;
	protected int idade;
	
	protected NivelDeAtividadeFisica nivelDeAtividadeFisica;
	protected Objetivo objetivoPessoal;
	
	public Individuo(
			double peso, 
			double altura, 
			int idade, 
			NivelDeAtividadeFisica nivelDeAtividadeFisica, 
			Objetivo objetivoPessoal) {
		this.peso = peso;
		this.altura = altura/100;
		this.idade = idade;
		this.nivelDeAtividadeFisica = nivelDeAtividadeFisica;
		this.objetivoPessoal = objetivoPessoal;
	}

	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}

	public int getIdade() {
		return idade;
	}

	public NivelDeAtividadeFisica getNivelDeAtividadeFisica() {
		return nivelDeAtividadeFisica;
	}
	
	public Objetivo getObjetivoPessoal() {
		return objetivoPessoal;
	}
	
	//	Indice de massa corporea
	abstract double getIMC();
	// 	Taxa Metabolica Basal
	abstract double getTMB();
	//	Necessidade Diaria de Calorias
	abstract double getNDC();
}
