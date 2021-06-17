
public class Testes {
	public static void main(String[] args) {
		Contato[] contatos = {
			new PessoaFisica("Jorge", "jorge@gmail.com", "jau", "965.305.460-06", "04/07/2000", "solteiro"),
			new PessoaFisica("Andre", "andre@gmail.com", "Sao Caetano", "712.499.720-86", "04/05/2001", "solteiro"),
			new PessoaFisica("Thamyres", "Thamy@gmail.com", "Campinas", "248.925.700-52", "12/01/2000", "solteiro"),
			new PessoaFisica("Renan", "Renan@gmail.com", "Santos", "564.981.490-27", "24/11/1999", "solteiro"),
			new PessoaFisica("Guilherme", "Gui@gmail.com", "Aracaju", "995.167.160-83", "17/12/2002", "solteiro"),
			new PessoaJuridica( "ICMC Júnior", "empresa@junior.com.br","São Carlos", "12.932.235/0001-09", "ltda", "001"),
			new PessoaJuridica( "POLI Júnior", "empresa@junior.com.br","São Carlos", "80.371.997/0001-25", "ltda", "002"),
			new PessoaJuridica( "FEA Júnior", "empresa@junior.com.br","São Carlos", "23.749.625/0001-56", "ltda", "003"),
			new PessoaJuridica( "CATI Júnior", "empresa@junior.com.br","São Carlos", "66.607.632/0001-26", "ltda", "004"),
			new PessoaJuridica( "CITI Júnior", "empresa@junior.com.br","São Carlos", "40.915.607/0001-16", "ltda", "005"),
		};
		
		Agenda agendaDeContatos = new Agenda();
		
		System.out.println("---------------- AGENDA ----------------\n");
		for (Contato contato : contatos) {
			if(!agendaDeContatos.adicionarContato(contato)) {
				System.out.println("Falha ao adicionar contato");
			}
		}
		System.out.println(agendaDeContatos);
		PessoaFisica pfBuscadaPorNome = (PessoaFisica)agendaDeContatos.buscar("Jorge");
		if(pfBuscadaPorNome != null) {
			System.out.println("ACHADA!");
			System.out.println(pfBuscadaPorNome );			
		}
		
		PessoaFisica pfBuscadaPorCpf = (PessoaFisica)agendaDeContatos.buscar("712.499.720-86");
		if(pfBuscadaPorNome != null) {
			System.out.println("ACHADA!");
			System.out.println(pfBuscadaPorCpf );			
		}
		
		PessoaJuridica pjBuscadaPorNome = (PessoaJuridica) agendaDeContatos.buscar("ICMC Júnior");
		if(pjBuscadaPorNome != null) {
			System.out.println("ACHADA!");
			System.out.println(pjBuscadaPorNome );			
		}
		
		PessoaJuridica pjBuscadaPorCnpj = (PessoaJuridica)agendaDeContatos.buscar("12.932.235/0001-09");
		if(pjBuscadaPorCnpj != null) {
			System.out.println("ACHADA!");
			System.out.println(pjBuscadaPorCnpj );			
		}
		
		if(agendaDeContatos.remover("Andre")) {
			System.out.println("Contato removido com sucesso!!");
		}
		
		if(agendaDeContatos.buscar("Andre") == null) {
			System.out.println("Contato inexistente !!");
		}
		
		agendaDeContatos.ordenar();
		System.out.println("--------------------------ORDENADA--------------------------");
		System.out.println(agendaDeContatos);
	}
}
