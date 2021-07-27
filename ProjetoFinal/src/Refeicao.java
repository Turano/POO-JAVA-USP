public class Refeicao{

    private int porcaoDeCarboidratos;
    private int porcaoDeProteinas;
    private int porcaoDeGorduras;

    /**
     *  Considere:
     *      - 1g carboidrato = 4 calorias;
     *      - 1g proteina = 4 calorias;
     *      - 1g gordura = 9 calorias;
     *      
     *  Dados retirado de https://www.tuasaude.com/o-que-sao-calorias/
     */

    public Refeicao(int porcaoDeCarboidratos, int porcaoDeProteinas, int porcaoDeGorduras){

        this.porcaoDeCarboidratos = porcaoDeCarboidratos;
        this.porcaoDeGorduras = porcaoDeGorduras;
        this.porcaoDeProteinas = porcaoDeProteinas;

    }

    public double getCalorias(){

        return (this.porcaoDeCarboidratos * 4) + (this.porcaoDeProteinas * 4) + (this.porcaoDeGorduras * 9);

    }


}