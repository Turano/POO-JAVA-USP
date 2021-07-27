import java.util.ArrayList;

public class Alimentacao{

    private ArrayList<Refeicao> totalRefeicoes = new ArrayList<Refeicao>();

    public void addRefeicao(int porcaoDeCarboidratos, int porcaoDeProteinas, int porcaoDeGorduras){
    	
    	Refeicao refeicao = new Refeicao(porcaoDeCarboidratos, porcaoDeProteinas, porcaoDeGorduras);

        totalRefeicoes.add(refeicao);
        
        return;

    }

    public void removeRefeicao(){
    	
    	try {
    		
            totalRefeicoes.remove(totalRefeicoes.size() - 1);

    	} catch(Exception E) {
    		
    		System.out.println("Nao ha refeicoes para remover!");
    		
    	}

        return;

    }

    public double getTotalDeCalorias(){

        double resultado = 0;

        for(int i = 0; i < totalRefeicoes.size(); i++){

            resultado += totalRefeicoes.get(i).getCalorias();

        }

        return resultado;

    }

}