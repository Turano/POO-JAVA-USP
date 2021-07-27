public class Refeicao{

    private int porcaoDeCarboidratos;
    private int porcaoDeProteinas;
    private int porcaoDeGorduras;

    /**
     *  Considere:
     *      - 1g carboidrato = 4 calorias;
     *      - 1g proteina = 4 calorias;
     *      - 1g gordura = 9 calorias;
     */

    public Refeicao(int porcaoDeCarboidratos, int porcaoDeProteinas, int porcaoDeGorduras){

        this.setPorcaoDeCarboidratos(porcaoDeCarboidratos);
        this.setPorcaoDeGorduras(porcaoDeGorduras);
        this.setPorcaoDeProteinas(porcaoDeProteinas);

    }

    public void setPorcaoDeCarboidratos(int porcaoDeCarboidratos){

        this.porcaoDeCarboidratos = porcaoDeCarboidratos;
        return;

    }

    public void setPorcaoDeProteinas(int porcaoDeProteinas){

        this.porcaoDeProteinas = porcaoDeProteinas;
        return;

    }

    public void setPorcaoDeGorduras(int porcaoDeGorduras){

        this.porcaoDeGorduras = porcaoDeGorduras;
        return;

    }

    public double getCalorias(){

        return (this.porcaoDeCarboidratos * 4) + (this.porcaoDeProteinas * 4) + (this.porcaoDeGorduras * 9);

    }


}