
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agenda {

	private int capacidade;
	private Contato[] listaDeContatos;
	private int numeroDeContatos;
	private int numeroDeCpfs;
	private int numeroDeCnpjs;
	
	public Agenda() {
		this.capacidade = 100;
		this.listaDeContatos = new Contato[this.capacidade];
		this.numeroDeContatos = 0;
		this.numeroDeCpfs = 0;
		this.numeroDeCnpjs = 0;
	}
	
	public Agenda(int capacidade) {
		this.capacidade = capacidade;
		this.listaDeContatos = new Contato[this.capacidade];
		this.numeroDeContatos = 0;
		this.numeroDeCpfs = 0;
		this.numeroDeCnpjs = 0;
	}
	
	public boolean adicionarContato(Contato novoContato) {
		if(this.numeroDeContatos < this.capacidade) {
			this.listaDeContatos[this.numeroDeContatos++] = novoContato;
			if (novoContato instanceof PessoaFisica) {
				this.numeroDeCpfs++;
			}else if (novoContato instanceof PessoaJuridica) {
				this.numeroDeCnpjs++;
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
		for (int i = 0; i < this.capacidade; i++) {
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
					this.numeroDeCnpjs--;
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
				this.numeroDeCnpjs--;
				return true;
			}
		}
		return false;
	}
	
	private boolean listaEstaVazia() {
		return (this.numeroDeContatos == 0);
	}

	public void ordenar() {
		PessoaFisica[] cpfsOrdenados = this.ordenarPorCpf();
		PessoaJuridica[] cnpjsOrdenados = this.ordenarPorCnpj();
		for (int i = 0; i < this.capacidade; i++) {
			if(i < this.numeroDeCpfs) {
				this.listaDeContatos[i] = cpfsOrdenados[i];
			}else if (i < this.numeroDeCpfs + this.numeroDeCnpjs ){
				this.listaDeContatos[i] = cnpjsOrdenados[i-this.numeroDeCpfs];
			}else {
				this.listaDeContatos[i] = null;
			}
		}
	}
	
	private PessoaFisica[] ordenarPorCpf() {
		PessoaFisica[] cpfsOrdenados = obterCpfsDaLista();
		for (int i = 0; i < cpfsOrdenados.length; i++) {
			for (int j = 0; j < cpfsOrdenados.length-1; j++) {
				String cpfSemPontuacao1 = cpfsOrdenados[j].getCpf().replace(".", "").replace("-", "");
				long cpf1 = Long.parseLong(cpfSemPontuacao1);
				
				String cpfSemPontuacao2 = cpfsOrdenados[j+1].getCpf().replace(".", "").replace("-", "");
				long cpf2 = Long.parseLong(cpfSemPontuacao2);
				
				if(cpf1 > cpf2) {
					swap(cpfsOrdenados, j, j+1);
				}
			}
		}
		return cpfsOrdenados;
	}
	
	private PessoaJuridica[] ordenarPorCnpj() {
		PessoaJuridica[] cnpjsOrdenados = obterCnpjsDaLista();
		for (int i = 0; i < cnpjsOrdenados.length; i++) {
			for (int j = 0; j < cnpjsOrdenados.length-1; j++) {
				String cnpjSemPontuacao1 = cnpjsOrdenados[j].getCnpj().replace(".", "").replace("-", "").replace("/", "");
				long cnpj1 = Long.parseLong(cnpjSemPontuacao1);
				
				String cnpjSemPontuacao2 = cnpjsOrdenados[j+1].getCnpj().replace(".", "").replace("-", "").replace("/", "");
				long cnpj2 = Long.parseLong(cnpjSemPontuacao2);
				
				if(cnpj1 > cnpj2) {
					swap(cnpjsOrdenados, j, j+1);
				}
			}
		}
		return cnpjsOrdenados;
	}
	
	private PessoaFisica[] obterCpfsDaLista() {
		PessoaFisica[] cpfs = new PessoaFisica[this.numeroDeCpfs];
		int i;
		int j = 0;
		for (i = 0; i < this.capacidade; i++) {
			if(this.listaDeContatos[i] instanceof PessoaFisica) {
				PessoaFisica pf = (PessoaFisica) this.listaDeContatos[i];
				cpfs[j++] = pf;
			}
		}
		return cpfs;
	}
	
	private PessoaJuridica[] obterCnpjsDaLista() {
		PessoaJuridica[] cnpjs = new PessoaJuridica[this.numeroDeCnpjs];
		int i;
		int j = 0;
		for (i = 0; i < this.capacidade; i++) {
			if(this.listaDeContatos[i] instanceof PessoaJuridica) {
				PessoaJuridica pj = (PessoaJuridica) this.listaDeContatos[i];
				cnpjs[j++] = pj;
			}
		}
		return cnpjs;
	}
	
	private void swap(Contato[] lista, int posicao1, int posicao2) {
		Contato temporario = lista[posicao1];
		lista[posicao1] = lista[posicao2];
		lista[posicao2] = temporario;
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
