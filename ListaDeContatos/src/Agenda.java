import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agenda {

	private int capacidade;
	private Contato[] listaDeContatos;
	private int numeroDeContatos;
	private int numeroDeCpfs;
	private int numeroDeCpnjs;
	
	public Agenda() {
		this.capacidade = 100;
		this.listaDeContatos = new Contato[this.capacidade];
		this.numeroDeContatos = 0;
		this.numeroDeCpfs = 0;
		this.numeroDeCpnjs = 0;
	}
	
	public Agenda(int capacidade) {
		this.capacidade = capacidade;
		this.listaDeContatos = new Contato[this.capacidade];
		this.numeroDeContatos = 0;
		this.numeroDeCpfs = 0;
		this.numeroDeCpnjs = 0;
	}
	
	public boolean adicionarContato(Contato novoContato) {
		if(this.numeroDeContatos < this.capacidade) {
			this.listaDeContatos[this.numeroDeContatos++] = novoContato;
			if (novoContato instanceof PessoaFisica) {
				this.numeroDeCpfs++;
			}else if (novoContato instanceof PessoaJuridica) {
				this.numeroDeCpnjs++;
			}
			return true;
		} else {
			return false;
		}
	}
	
	public Contato buscar(String campoDeBusca) {
		if (campoDeBusca.length() == 0) {
			return null;
		} else if (isCpf(campoDeBusca)) {
			return buscaPorCpf(campoDeBusca);
		} else if (isCnpj(campoDeBusca)) {
			return buscaPorCnpj(campoDeBusca);
		} else {
			return buscaPorNome(campoDeBusca);
		}
	}
	
	
	private boolean isCpf(String input) {
		String regex = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
        return m.matches();		
	}
	
	private boolean isCnpj(String input) {
		String regex = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}-[0-9]{2}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
        return m.matches();		
	}
	
	private Contato buscaPorNome(String nome) {
		int posicao = buscaPosicaoPorNome(nome);
		if(posicao >= 0) {
			return listaDeContatos[posicao];
		}else {
			return null;
		}
	}
	
	private int buscaPosicaoPorNome(String nome) {
		for (int i = 0; i < this.numeroDeContatos; i++) {
			if(listaDeContatos[i] != null && listaDeContatos[i].getNome().equals(nome)) {
				return i;
			}			
		}
		return -1;
	}
	
	private Contato buscaPorCpf(String cpf) {
		int posicao = buscaPosicaoPorCpf(cpf);
		if(posicao >= 0) {
			return listaDeContatos[posicao];
		}else {
			return null;
		}
	}
	
	private int buscaPosicaoPorCpf(String cpf) {
		for (int i = 0; i < this.numeroDeContatos; i++) {
			if(listaDeContatos[i] != null && listaDeContatos[i] instanceof PessoaFisica && ((PessoaFisica) listaDeContatos[i]).getCpf().equals(cpf)) {
				return i;				
			}
		}
		return -1;
	}
	
	private Contato buscaPorCnpj(String cnpj) {
		int posicao = buscaPosicaoPorCnpj(cnpj);
		if(posicao >= 0) {
			return listaDeContatos[posicao];
		}else {
			return null;
		}
	}
	
	private int buscaPosicaoPorCnpj(String cnpj) {
		for (int i = 0; i < this.numeroDeContatos; i++) {
			if(listaDeContatos[i] != null && listaDeContatos[i] instanceof PessoaJuridica && ((PessoaJuridica) listaDeContatos[i]).getCnpj().equals(cnpj)) {
				return i;				
			}
		}
		return -1;
	}
	
	public boolean remover(String campoDeBusca) {
		if (campoDeBusca.length() == 0) {
			return false;
		} else if (isCpf(campoDeBusca)) {
			return removerContatoPorCpf(campoDeBusca);
		} else if (isCnpj(campoDeBusca)) {
			return removerContatoPorCnpj(campoDeBusca);
		} else {
			return removerContatoPorNome(campoDeBusca);
		}
	}
	
	private boolean removerContatoPorNome(String nome) {
		if(!this.listaEstaVazia()) {
			int posicao = buscaPosicaoPorNome(nome);
			if(posicao >= 0) {
				if(this.listaDeContatos[posicao] instanceof PessoaFisica) {
					this.numeroDeCpfs--;
				}else if (this.listaDeContatos[posicao] instanceof PessoaJuridica) {
					this.numeroDeCpnjs--;
				}
				this.listaDeContatos[posicao] = null;
				this.numeroDeContatos--;
				return true;
			}			
		}
		return false;
	}
	
	private boolean removerContatoPorCpf(String cpf) {
		if(!this.listaEstaVazia()) {
			int posicao = buscaPosicaoPorCpf(cpf);
			if(posicao >= 0) {
				listaDeContatos[posicao] = null;
				this.numeroDeContatos--;
				this.numeroDeCpfs--;
				return true;
			}
		}
		return false;
	}
	
	public boolean removerContatoPorCnpj(String cnpj) {
		if(!this.listaEstaVazia()) {
			int posicao = buscaPosicaoPorCnpj(cnpj);
			if(posicao >= 0) {
				listaDeContatos[posicao] = null;
				this.numeroDeContatos--;
				this.numeroDeCpnjs--;
				return true;
			}
		}
		return false;
	}
	
	private boolean listaEstaVazia() {
		return (this.numeroDeContatos == 0);
	}
	
	@Override
	public String toString() {
		if(this.listaEstaVazia()) {
			return "Agenda Vazia!!\n";
		}
		String agenda = "";
		for (int i = 0; i < this.numeroDeContatos; i++) {
			agenda += this.listaDeContatos[i].toString();
			agenda += "\n";
		}
		return agenda;
	}
}
