import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RolaDadosTest {
	private RolaDados rolaDadosTest;
	
	static private int numeroDeDadosTest = 5;

	@BeforeEach
	void setUp() throws Exception {
		rolaDadosTest = new RolaDados(RolaDadosTest.numeroDeDadosTest);
	}

	@AfterEach
	void tearDown() throws Exception {
		rolaDadosTest = null;
	}

	@Test
	void testGetNumeroDeDados() {
		int resultadoObtido = rolaDadosTest.getNumeroDeDados();
		assertEquals(resultadoObtido, RolaDadosTest.numeroDeDadosTest);
	}

	@Test
	void testRolar() {
		int lados[] = rolaDadosTest.rolar();
		boolean ladosSaoValidos = true;
		for (int i = 0; i < lados.length; i++) {
			if (!(lados[i]>0 && lados[i] <= 6)){
				ladosSaoValidos = false;
			}
		}
		assertTrue(ladosSaoValidos);
	}

	@Test
	void testRolarBooleanArray() {
		int ladosInicio[] = rolaDadosTest.rolar(new boolean[] {false, true, true, true, false});
		int ladosFim[] = rolaDadosTest.rolar(new boolean[] {false, true, true, true, false});
		boolean ladosSaoValidos = true;
		
		if(ladosInicio[0] != ladosFim[0] || ladosInicio[4] != ladosFim[4]) {
			ladosSaoValidos = false;
		}
		assertTrue(ladosSaoValidos);
	}

	@Test
	void testRolarString() {
		int ladosInicio[] = rolaDadosTest.rolar("1 4 5");
		int ladosFim[] = rolaDadosTest.rolar("1 4 5");
		boolean ladosSaoValidos = true;
		
		if(ladosInicio[1] != ladosFim[1] || ladosInicio[2] != ladosFim[2]) {
			ladosSaoValidos = false;
		}
		assertTrue(ladosSaoValidos);
	}
}
