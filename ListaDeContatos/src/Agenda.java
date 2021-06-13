
public class Agenda {
	public static void main(String[] args) {
		PessoaFisica p1 = new PessoaFisica(
				"Luis", 
				"luis.jorge@icmcjunior.com.br", 
				"JAU-SP", 
				"424.067.698-36", 
				"04/07/2000",
				"solteiro");
		p1.setNome("Luis Felipe Jorge");
		System.out.println(p1.getNome());
		System.out.println(p1.getData());
		System.out.println(p1.getEmail());
		System.out.println(p1.getEndereco());
		System.out.println(p1.getEstadoCivil());
		System.out.println(p1.getCpf());

		PessoaJuridica p2 = new PessoaJuridica(
				"ICMC Júnior", 
				"contatocomercial@icmcjunior.com.br", 
				"SAO-CARLOS-SP", 
				"14.572.457/0001-85", 
				"ICMSC JUNIOR", 
				"111");

		System.out.println(p2.getNome());
		System.out.println(p2.getRazaoSocial());
		System.out.println(p2.getEmail());
		System.out.println(p2.getEndereco());
		System.out.println(p2.getInscricaoEstadual());
		System.out.println(p2.getCnpj());
		
//		
	}
}
