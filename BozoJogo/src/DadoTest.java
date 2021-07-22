import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DadoTest {
	private Dado dadoTest;
	
	@BeforeEach
	public void setUp() throws Exception {
		dadoTest = new Dado();
	}

	@AfterEach
	public void tearDown() throws Exception {
		dadoTest = null;
	}

	@Test
	public void testRolar() {
		int primeiraRolada = dadoTest.rolar();
		int segundaRolada = dadoTest.rolar();
		
		assertNotEquals(primeiraRolada, segundaRolada);
	}
	 
	
	@Test
	public void testGetLado() {
		dadoTest.rolar();
		int ladoObtido = dadoTest.getLado();
		boolean ladoEhValido = (ladoObtido>0 && ladoObtido <= 6);
		assertTrue(ladoEhValido);
	}
	
	@Test
	public void testToString() {
		String resultadoEsperado[] = new String[6];
		resultadoEsperado[0] = (
						  "+-----+	\n"
						+ "|     |	\n"
						+ "|  *  |	\n"
						+ "|     |	\n"
						+ "+-----+	\n"
					);
		resultadoEsperado[1] = (
				  "+-----+	\n"
				+ "|*    |	\n"
				+ "|     |	\n"
				+ "|    *|	\n"
				+ "+-----+	\n"
			);
		resultadoEsperado[2] = (
				  "+-----+	\n"
				+ "|*    |	\n"
				+ "|  *  |	\n"
				+ "|    *|	\n"
				+ "+-----+	\n"
			);	
		resultadoEsperado[3] =(
				  "+-----+	\n"
				+ "|*   *|	\n"
				+ "|     |	\n"
				+ "|*   *|	\n"
				+ "+-----+	\n"
			);		
		resultadoEsperado[4] = (
				  "+-----+	\n"
				+ "|*   *|	\n"
				+ "|  *  |	\n"
				+ "|*   *|	\n"
				+ "+-----+	\n"
			);		
		resultadoEsperado[5] = (
				  "+-----+	\n"
				+ "|*   *|	\n"
				+ "|*   *|	\n"
				+ "|*   *|	\n"
				+ "+-----+	\n"
			);		
		
		List<String> valoresPossiveis = Arrays.asList(resultadoEsperado);
		// testa 100 vezes para passar por todos os possiveis valores

		for (int i = 0; i < 100; i++) {
			dadoTest.rolar();
			String resultadoObtido = dadoTest.toString();
			if (!(valoresPossiveis.contains(resultadoObtido))) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	}

}
