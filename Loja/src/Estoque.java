
public class Estoque {
	private int quantidaeDeLivros;
	private int quantidadeDeCds;
	private int quantidadeDeDvds;
	
	
	
	public Estoque() {
		this.quantidaeDeLivros = 0;
		this.quantidadeDeCds = 0;
		this.quantidadeDeDvds = 0;
	}
	
	public int getQuantidaeDeLivros() {
		return quantidaeDeLivros;
	}

	public int getQuantidadeDeCds() {
		return quantidadeDeCds;
	}

	public int getQuantidadeDeDvds() {
		return quantidadeDeDvds;
	}

	public void adicionarAoEstoque(Produto produto, int amount) {
		if(produto instanceof Livro) {
			this.quantidaeDeLivros += amount;
		}else if (produto instanceof CD) {
			this.quantidadeDeCds += amount;
		} else {
			this.quantidadeDeDvds += amount;
		}
	}
	
	public void removerDoEstoque(Produto produto, int amount) {
		if(produto instanceof Livro) {
			this.quantidaeDeLivros -= amount;
		}else if (produto instanceof CD) {
			this.quantidadeDeCds -= amount;
		} else {
			this.quantidadeDeDvds -= amount;
		}
	}
	
	public int obterQuantidadeTotal() {
		return this.quantidaeDeLivros + this.quantidadeDeCds + this.quantidadeDeDvds;
	}
}
