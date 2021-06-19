
public class Testes {
	public static void main(String[] args) {
		Produto[] produtos = {
			new Livro(963, "Encontre seu porquê", "Simon Sinek", 1, "especial", "Sextante", "2018"),
			new Livro(5737, "Comece pelo porquê", 4, "Simon Sinek", 2, "capa dura", "Sextante", "2018"),
			new CD(3458, "Evolve", "Intescope Records", "2018"), 
			new CD(4850, "Coisas da geração", 10, "Sony music entertainment brasil ltda", "2018"),
			new Dvd(6864, "DVD Player Multimídia 3 em 1 Multilaser Bivolt CD/DVD/Pendrive Preto Compacto", "Sony", "2011"),
			new Dvd(5533, "DVD Game PH150 USB, MP3, Função Game, 2 Joysticks",6, "Philco", "2013")
		};
		
		Loja loja = new Loja();
		loja.adicionarProdutos(produtos);
		System.out.println("---------------------LOJA---------------------");
		System.out.println(loja.obterEstoque());
		
		System.out.println("---------------------BUSCAS---------------------");
		System.out.println("Produto achado pelo nome:");
		System.out.println(loja.buscar("Evolve"));
		System.out.println("Prodto achado pelo código:");
		System.out.println(loja.buscar(4850));
	
		System.out.println("---------------------VENDAS---------------------");		
		if(loja.vender(4850, 2)) {
			System.out.println("Produto vendido com sucesso");
		}
		if(loja.vender(963)) {
			System.out.println("Produto vendido com sucesso");
		}
		if(!loja.vender(963)) {
			System.out.println("Produto indisponível");
		}
		
		System.out.println("---------------------RESULTADO FINAL---------------------");
		System.out.println(loja.obterEstoque());
	}
}
