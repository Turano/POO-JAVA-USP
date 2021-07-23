
public abstract class Individuo {
	protected double peso;
	protected double altura;
	protected int idade;
	
	protected NivelDeAtividadeFisica nivelDeAtivFis;
	
	public Individuo(double peso, double altura, int idade, NivelDeAtividadeFisica nivelDeAtivFis) {
		super();
		this.peso = peso;
		this.altura = altura;
		this.idade = idade;
		this.nivelDeAtivFis = nivelDeAtivFis;
	}

	abstract double getNDC();

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public NivelDeAtividadeFisica getNivelDeAtivFis() {
		return nivelDeAtivFis;
	}

	public void setNivelDeAtivFis(NivelDeAtividadeFisica nivelDeAtivFis) {
		this.nivelDeAtivFis = nivelDeAtivFis;
	}
	
	//	Indice de massa corporea
	abstract double getIMC();
	// 	Taxa Metabolica Basal
	abstract double getTMB();
	//	Necessidade Diaria de Calorias
}
