
public class CalculadoraIMC implements IMC {
	// Calculo inspirado: https://centrodeobesidadeediabetes.org.br/tudo-sobre-obesidade/calculadora-de-imc/
	@Override
	public double getIMC(Individuo individuo) {
		return (individuo.getPeso()/(individuo.getAltura()*individuo.getAltura())); //(kg/ m²)
	}
	
	@Override
	public double getFaltaParaPesoSaudavel(Individuo individuo) {
		double imc = this.getIMC(individuo);
		double pesoAtual = individuo.getPeso();
		double pesoIdeal = 24.9*individuo.getAltura()*individuo.getAltura();
		if (imc >= 18.5 && imc < 24.9) {
			return 0;
		}
		return pesoAtual - pesoIdeal;
	}
	
	@Override
	public String getSugestaoDePeso(Individuo individuo) {
		double faltaParaPesoSaudavel = this.getFaltaParaPesoSaudavel(individuo);
		String mensagemDeSugestao = "";
		if (faltaParaPesoSaudavel < 0) {
			mensagemDeSugestao += "Você está abaixo do peso, seria interessante que ganhasse "+String.format("%.0f", Math.abs(faltaParaPesoSaudavel))+" quilos para manter sua saúde.\n";
		} else if (faltaParaPesoSaudavel == 0) {
			mensagemDeSugestao += "Você já está em seu peso ideal, continue assim para o bem da sua saúde.";
		} else {
			mensagemDeSugestao += "Você está acima do seu peso, por favor repense seus hábitos para ter uma vida mais saudável.\n";
			mensagemDeSugestao += "Seria necessário perder no mínimo " + String.format("%.0f", (faltaParaPesoSaudavel)) + " quilo(s).";
		}
		return mensagemDeSugestao;
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
