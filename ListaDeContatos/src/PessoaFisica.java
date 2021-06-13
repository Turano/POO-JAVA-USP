import java.util.InputMismatchException;

public class PessoaFisica extends Contato{

	private String cpf;
	private String dataDeNascimento;
	private String estadoCivil;
	
	public PessoaFisica(
			String nome, 
			String email, 
			String endereco,
			String cpf,
			String dataDeNascimento,
			String estadoCivil) {
		super(nome, email, endereco);
		setData(dataDeNascimento);
		setEstadoCivil(estadoCivil);
		setCpf(cpf);
	}
	
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) throws IllegalArgumentException{
		String cpfSemPontuação = cpf.replace(".", "");
		cpfSemPontuação = cpfSemPontuação.replace("-", "");
		if (!isValidCpf(cpfSemPontuação)) {
			throw new IllegalArgumentException("CPF Inválido");
		} 
		this.cpf = cpf;						
	}
	
	public String getData() {
		return dataDeNascimento;
	}
	
	public void setData(String data) {
		this.dataDeNascimento = data;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	private boolean isValidCpf(String cpf) {
		
		// cpfs inávlidos
		// qualquer string com mais ou menos do que 11 caracteres é inválida
		// sequencias numericas repetidas são inválidas
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || 
        	cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || 
            cpf.equals("99999999999") || cpf.length() != 11 ) {
        	return(false);
        }
        // algoritmo baseado na versão fornecida pela secretaria da fazenda
        // http://www.receita.fazenda.gov.br/aplicacoes/atcta/cpf/funcoes.js
        // PS:Os números de 0 a 9
        // são codificados em ascii de 48 a 57 
        
        char digitoVerificador1, digitoVerificador2;
        int somatorio, resto, numerico, peso;
        
        
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        	// validação do 1o. Digito Verificador
            somatorio = 0;
            peso = 10;
            for (int i = 0; i < 9; i++) {
	            numerico = (int)(cpf.charAt(i) - 48);
	            somatorio += (numerico * peso);
	            peso--;
            }

            resto = somatorio % 11;
            if ((resto == 0) || (resto == 1)) {
            	digitoVerificador1 = '0';            	
            } else {
            	digitoVerificador1 = (char)((11 - resto) + 48);
            }
        
            // validação do 2o. Digito Verificador
            somatorio = 0;
            peso = 11;
            for(int i = 0; i < 10; i++) {
	            numerico = (int)(cpf.charAt(i) - 48);
	            somatorio += (numerico * peso);
	            peso--;
            }

            resto = somatorio % 11;
            if ((resto == 0) || (resto == 1)) {
            	digitoVerificador2 = '0';
            } else {
            	digitoVerificador2 = (char)((11-resto) + 48);
            }

            // Compara os valores calculados com os digitos verificadores inseridos.
            return (digitoVerificador1 == cpf.charAt(9) && digitoVerificador2 == cpf.charAt(10));
        
        } catch (InputMismatchException erro) {
        	System.out.println("CPF Inserido de maneira inadequada");
            return(false);
        }
	}
	
}
