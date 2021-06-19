
public class Loja {
	private Produto[] produtos;
	private int capacidade;
	private int quantidadeDeProdutos;
	private Estoque estoque;
	
	public Loja() {
		this.capacidade = 100;
		this.produtos = new Produto[this.capacidade];
		this.estoque = new Estoque();
	}
	
	public Loja(int capacidade) {
		this.capacidade = capacidade;
		this.produtos = new Produto[this.capacidade];
		this.estoque = new Estoque();
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
				estoque.adicionarAoEstoque(produto, produto.getAvailableQuantity());
			}else {
				this.produtos[this.quantidadeDeProdutos++] = produto;	
				estoque.adicionarAoEstoque(produto, produto.getAvailableQuantity());
			}
			return true;
		}
		return false;
	}
	
	public boolean adicionarProdutos(Produto[] produtosNovos) {
		if(this.quantidadeDeProdutos < capacidade) {
			int i = 0;
			while (this.quantidadeDeProdutos < capacidade && i < produtosNovos.length) {
				int posicao = this.buscarPosicaoPorNome(produtosNovos[i].getNome());
				if(posicao > 0) {
					this.produtos[posicao].increaseAvailableQuantity(produtosNovos[i].getAvailableQuantity());
					estoque.adicionarAoEstoque(produtosNovos[i], produtosNovos[i].getAvailableQuantity());
				}else {
					this.produtos[this.quantidadeDeProdutos++] = produtosNovos[i];		
					estoque.adicionarAoEstoque(produtosNovos[i], produtosNovos[i].getAvailableQuantity());
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
			estoque.removerDoEstoque(this.produtos[posicao], 1);
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
			estoque.removerDoEstoque(this.produtos[posicao], amount);
			if(this.produtos[posicao].getAvailableQuantity() == 0) {
				this.produtos[posicao] = null;				
			}
			return true;
		}
		return false;
	}
	
	public String obterEstoque() {
		String resultado = "";
		resultado += 
				"Livros:" + "\n"
				+"Dísponiveis: " + estoque.getQuantidaeDeLivros() + "\n";
		for(Produto produto : produtos) {
			if (produto instanceof Livro) {
				resultado += produto;
			}
		}
		resultado += "\n" + 
				"CDs:" + "\n"
				+"Dísponiveis: " + estoque.getQuantidadeDeCds() + "\n";
		for(Produto produto : produtos) {
			if (produto instanceof CD) {
				resultado += produto;
			}
		}
		resultado += "\n" + 
				"DVDs:" + "\n"
				+"Dísponiveis: " + estoque.getQuantidadeDeDvds() + "\n";
		for(Produto produto : produtos) {
			if (produto instanceof Dvd) {
				resultado += produto;
			}
		}
		return resultado;
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
