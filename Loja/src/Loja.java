
public class Loja {
	private Produto[] produtos;
	private int capacidade;
	private int quantidadeDeProdutos;
	
	public Loja() {
		this.capacidade = 100;
		this.produtos = new Produto[this.capacidade];
	}
	
	public Loja(int capacidade) {
		this.capacidade = capacidade;
		this.produtos = new Produto[this.capacidade];
	}

	public Produto[] getProdutos() {
		return produtos;
	}

	public int getCapacidade() {
		return capacidade;
	}
	
	public int getQuantidadeDeProdutos() {
		return quantidadeDeProdutos;
	}
	
	public boolean adicionarProdutos(Produto produto) {
		if(this.quantidadeDeProdutos < capacidade) {
			int posicao = this.buscarPosicaoPorNome(produto.getNome());
			if(posicao > 0) {
				this.produtos[posicao].increaseAvailableQuantity(produto.getAvailableQuantity());
			}else {
				this.produtos[this.quantidadeDeProdutos++] = produto;				
			}
			return true;
		}
		return false;
	}
	
	public boolean adicionarProdutos(Produto[] produtos) {
		if(this.quantidadeDeProdutos < capacidade) {
			int i = 0;
			while (this.quantidadeDeProdutos < capacidade && i < produtos.length) {
				int posicao = this.buscarPosicaoPorNome(produtos[i].getNome());
				if(posicao > 0) {
					this.produtos[posicao].increaseAvailableQuantity(produtos[i].getAvailableQuantity());
				}else {
					this.produtos[this.quantidadeDeProdutos++] = produtos[i];			
				}
				i++;
			}
			if(i == produtos.length) return true;				
		}
		return false;
	}

	public Produto buscar(String nome) {
		int posicao = buscarPosicaoPorNome(nome);
		if(posicao > 0) { return this.produtos[posicao]; }
		return null;
	}
	
	public Produto buscar(int codigoDeBarra) {
		int posicao = buscarPosicaoPorCodigo(codigoDeBarra);
		if(posicao > 0) { return this.produtos[posicao]; }
		return null;
	}
	
	private int buscarPosicaoPorNome(String nome) {
		for (int i = 0; i < this.capacidade; i++) {
			if(this.produtos[i] != null && this.produtos[i].getNome().equals(nome)) { return i; }
		}
		return -1;
	}
	
	private int buscarPosicaoPorCodigo(int codigo) {
		for (int i = 0; i < this.capacidade; i++) {
			if(this.produtos[i] != null && this.produtos[i].getCodigoDeBarras() == codigo) { return i; }
		}
		return -1;
	}
	
	public boolean vender(int codigoDeBarras) {
		int posicao = buscarPosicaoPorCodigo(codigoDeBarras);
		if(posicao < 0) return false;
		if (this.produtos[posicao].decreaseAvailableQuantity()) {
			if(this.produtos[posicao].getAvailableQuantity() == 0) {
				this.produtos[posicao] = null;				
			}
			return true;
		}
		return false;
	}
	
	public boolean vender(int codigoDeBarras, int amount) {
		int posicao = buscarPosicaoPorCodigo(codigoDeBarras);
		if (this.produtos[posicao].decreaseAvailableQuantity(amount)) {
			if(this.produtos[posicao].getAvailableQuantity() == 0) {
				this.produtos[posicao] = null;				
			}
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String resultado = "";
		for (Produto produto : this.produtos) {
			if(produto != null) { resultado += produto; }
		}
		return resultado;
	}
}
