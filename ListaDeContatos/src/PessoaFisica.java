
public class PessoaFisica extends Contato{
	private String cpf;
	private String data;
	private String estadoCivil;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if (isValidCpf(cpf)) {
			this.cpf = cpf;						
		}
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	private boolean isValidCpf(String cpf) {
		// TODO
		return true;
	}
	
}
