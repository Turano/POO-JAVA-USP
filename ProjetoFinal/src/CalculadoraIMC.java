
public class CalculadoraIMC implements IMC {
	// Calculo inspirado: https://centrodeobesidadeediabetes.org.br/tudo-sobre-obesidade/calculadora-de-imc/
	@Override
	public double getIMC(Individuo individuo) {
		return (individuo.getPeso()/(individuo.getAltura()*individuo.getAltura())); //(kg/ m²)
	}
	
	@Override
	public double getPesoParaSerPerdido(Individuo individuo) {
		double pesoAtual = individuo.getPeso();
		double pesoIdeal = 24.9*individuo.getAltura()*individuo.getAltura();
		return pesoAtual - pesoIdeal;
	}

	@Override
	public ClassificacaoDePeso getHealthCondition(Individuo individuo) {
		double imc_atual = this.getIMC(individuo);
		ClassificacaoDePeso classificacao;
		
		if (imc_atual < 18.5){
			classificacao  = ClassificacaoDePeso.ABAIXO_DO_PESO;
		}else if (imc_atual < 24.9){
			classificacao = ClassificacaoDePeso.NORMAL;
		}else if (imc_atual < 29.9){
			classificacao = ClassificacaoDePeso.SOBREPESO;
		}else if (imc_atual < 34.9){
			classificacao = ClassificacaoDePeso.OBESIDADE_GRAU1;
		}else if (imc_atual < 39.9){
			classificacao = ClassificacaoDePeso.OBESIDADE_GRAU2;
		}else {
			classificacao = ClassificacaoDePeso.OBESIDADE_GRAU3;
		}
		return classificacao;
	}
}
