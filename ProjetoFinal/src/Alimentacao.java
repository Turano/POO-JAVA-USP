import java.util.ArrayList;

public class Alimentacao{

    private ArrayList<Refeicao> totalRefeicoes = new ArrayList();

    private void addRefeicao(Refeicao refeicao){

        totalRefeicoes.add(refeicao);
        
        return;

    }

    private void removeRefeicao(){

        totalRefeicoes.remove(totalRefeicoes.size() - 1);
        return;

    }

    private double getTotalDeCalorias(){

        double resultado = 0;

        for(int i = 0; i < totalRefeicoes.size(); i++){

            resultado += totalRefeicoes.get(i).getCalorias();

        }

        return resultado;

    }

}