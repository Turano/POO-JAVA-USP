
public abstract class Individuo {
	protected double peso;
	protected double altura;
	protected int idade;
	
	protected NivelDeAtividadeFisica nivelDeAtividadeFisica;
	
	public Individuo(double peso, double altura, int idade, NivelDeAtividadeFisica nivelDeAtividadeFisica) {
		super();
		this.peso = peso;
		this.altura = altura;
		this.idade = idade;
		this.nivelDeAtividadeFisica = nivelDeAtividadeFisica;
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
	
	//	Indice de massa corporea
	abstract double getIMC();
	// 	Taxa Metabolica Basal
	abstract double getTMB();
	//	Necessidade Diaria de Calorias
	abstract double getNDC();
}
