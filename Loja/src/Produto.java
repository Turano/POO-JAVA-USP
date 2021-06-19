
public abstract class Produto {
	protected int codigoDeBarras;
	protected String nome;
	protected int availableQuantity;
	
	public Produto(int codigoDeBarras, String nome) {
		super();
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.availableQuantity = 1;
	}
	
	public Produto(int codigoDeBarras, String nome, int availableQuantity) {
		super();
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.availableQuantity = availableQuantity;
	}
	
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	
	public void increaseAvailableQuantity() {
		this.availableQuantity++;
	}
	
	public void increaseAvailableQuantity(int amount) {
		this.availableQuantity += amount;
	}
	
	public boolean decreaseAvailableQuantity() {
		if(this.availableQuantity > 0) { 
			this.availableQuantity--; 
			return true;
		}
		return false;
	}
	
	public boolean decreaseAvailableQuantity(int amount) {
		if(this.availableQuantity - amount > 0) { 
			this.availableQuantity -= amount; 
			return true;
		}
		return false;
	}
	
	public int getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(int codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Nome: "+ this.nome + "\n"
				+"Código: " + this.codigoDeBarras + "\n"
				+"Quantidade disponível: " + this.availableQuantity + "\n";
	}
}
