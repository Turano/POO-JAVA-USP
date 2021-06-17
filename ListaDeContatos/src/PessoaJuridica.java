import java.util.InputMismatchException;

public class PessoaJuridica extends Contato{

	private String cnpj;
	private String razaoSocial;
	private String inscricaoEstadual;
	
	public PessoaJuridica(
			String nome, 
			String email, 
			String endereco,
			String cnpj,
			String razaoSocial,
			String inscricaoEstadual) {
		super(nome, email, endereco);
		this.razaoSocial = razaoSocial;
		this.inscricaoEstadual = inscricaoEstadual;
		setCnpj(cnpj);
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) throws IllegalArgumentException {
		String cnpjSemPontuação = cnpj.replace(".", "");
		cnpjSemPontuação = cnpjSemPontuação.replace("-", "");
		cnpjSemPontuação = cnpjSemPontuação.replace("/", "");
		
		if (!isValidCnpj(cnpjSemPontuação)) {
			throw new IllegalArgumentException("CNPJ Inválido");
		} 
		this.cnpj = cnpj;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
private boolean isValidCnpj(String cnpj) {
		
		// cnpjs inávlidos
		// qualquer string com mais ou menos do que 14 caracteres é inválida
		// sequencias numericas repetidas são inválidas
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("2222222222222") || 
        	cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
            cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888") || 
            cnpj.equals("99999999999999") || cnpj.length() != 14 ) {
        	return(false);
        }
        // algoritmo baseado na versão fornecida 
        // http://www.macoratti.net/alg_cnpj.htm
        // PS:Os números de 0 a 9
        // são codificados em ascii de 48 a 57 
        
        char digitoVerificador1, digitoVerificador2;
        int somatorio, resto, numerico;
        int[] pesos1 = new int[] { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int[] pesos2 = new int[] { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        	// validação do 1o. Digito Verificador
            somatorio = 0;
            for (int i = 0; i < pesos1.length; i++) {
	            numerico = (int)(cnpj.charAt(i) - 48);
	            somatorio += (numerico * pesos1[i]);
            }

            resto = somatorio % 11;
            if ((resto == 0) || (resto == 1)) {
            	digitoVerificador1 = '0';            	
            } else {
            	digitoVerificador1 = (char)((11 - resto) + 48);
            }
        
            // validação do 2o. Digito Verificador
            somatorio = 0;
            for(int i = 0; i < pesos2.length; i++) {
	            numerico = (int)(cnpj.charAt(i) - 48);
	            somatorio += (numerico * pesos2[i]);
            }

            resto = somatorio % 11;
            if ((resto == 0) || (resto == 1)) {
            	digitoVerificador2 = '0';
            } else {
            	digitoVerificador2 = (char)((11-resto) + 48);
            }

            // Compara os valores calculados com os digitos verificadores inseridos.
            return digitoVerificador1 == cnpj.charAt(12) && digitoVerificador2 == cnpj.charAt(13);
        
        } catch (InputMismatchException erro) {
        	System.out.println("CNPJ Inserido de maneira inadequada");
            return(false);
        }
	}

	@Override
	public String toString() {
		String pessoaJuridica = "";
		pessoaJuridica += super.toString();
		pessoaJuridica += "Cnpj: " + this.getCnpj() + "\n";
		pessoaJuridica += "Razão Social: " + this.getRazaoSocial() + "\n";
		pessoaJuridica += "Inscrição Estadual: " + this.getInscricaoEstadual() + "\n";
		
		return pessoaJuridica;
	}
}
