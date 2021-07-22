import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlacarTest {
	private Placar placarTest;
	private static Placar placarTest2;
	
	@Before
	public void setUp() throws Exception {
		placarTest = new Placar();
	}
	
	@BeforeClass
	public static void setupBeforeClass() {  
		placarTest2 = new Placar();    
	}

	@After
	public void tearDown() throws Exception {
		placarTest = null;
	}

	@Test
	public void testAddJogadaSimples() {
		placarTest.add(1, new int[] {1,1,1,1,1});
		placarTest.add(2, new int[] {2,2,1,1,1});
		placarTest.add(3, new int[] {1,1,3,3,3});
		placarTest.add(4, new int[] {1,1,4,4,4});
		placarTest.add(5, new int[] {1,1,1,5,5});
		placarTest.add(6, new int[] {1,1,1,1,6});
		
		int resultadoObtido = placarTest.getScore();
		int retultadoEsperado = 5*1+2*2+3*3+3*4+2*5+6;
		assertEquals(resultadoObtido, retultadoEsperado);
	}
	
	@Test
	public void testAddFullHand() {
		placarTest.add(7, new int[] {2,2,1,1,1});
		
		int resultadoObtido = placarTest.getScore();
		int retultadoEsperado = 15;
		assertEquals(resultadoObtido, retultadoEsperado);
	}
	
	@Test
	public void testAddSequencia1a5() {
		placarTest.add(8, new int[] {1,2,3,4,5});
		
		int resultadoObtido = placarTest.getScore();
		int retultadoEsperado = 20;
		assertEquals(resultadoObtido, retultadoEsperado);
	}
	
	@Test
	public void testAddSequencia2a6() {
		placarTest.add(8, new int[] {2,3,4,5,6});
		
		int resultadoObtido = placarTest.getScore();
		int retultadoEsperado = 20;
		assertEquals(resultadoObtido, retultadoEsperado);
	}
	
	@Test
	public void testAddQuadra() {
		placarTest.add(9, new int[] {1,1,1,1,5});
		
		int resultadoObtido = placarTest.getScore();
		int retultadoEsperado = 30;
		assertEquals(resultadoObtido, retultadoEsperado);
	}
	
	@Test
	public void testAddQuina() {
		placarTest.add(10, new int[] {1,1,1,1,1});
		
		int resultadoObtido = placarTest.getScore();
		int retultadoEsperado = 40;
		assertEquals(resultadoObtido, retultadoEsperado);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddPosInvalida() {
		placarTest.add(0, new int[] {1,1,1,1,1});
	}
	
	@Test
	public void testGetScore() {
		int resultadoObtido = placarTest.getScore();
		assertEquals(0, resultadoObtido);
	}
	
	@Test
	public void testGetScoreCompleto() {
		placarTest.add(1, new int[] {1, 2, 3, 4, 5} );
		placarTest.add(2, new int[] {1, 2, 3, 4, 5} );
		placarTest.add(3, new int[] {1, 2, 3, 4, 5} );
		placarTest.add(4, new int[] {1, 2, 3, 4, 5} );
		placarTest.add(5, new int[] {1, 2, 3, 4, 5} );
		placarTest.add(6, new int[] {1, 2, 3, 4, 5} );
		placarTest.add(7, new int[] {1, 2, 3, 4, 5} );
		placarTest.add(8, new int[] {1, 2, 3, 4, 5} );
		placarTest.add(9, new int[] {1, 2, 3, 4, 5} );
		placarTest.add(10, new int[] {1, 2, 3, 4, 5} );
		
		
		int resultadoObtido = placarTest.getScore();
		assertEquals(35, resultadoObtido);
	}

	@Test
	public void testToString() {
		String resultadoEsperado = "(1)    |   (7)    |   (4)\n"
				+  "--------------------------\n"
				+  "(2)    |   (8)    |   (5)\n"
				+  "--------------------------\n"
				+  "(3)    |   (9)    |   (6)\n"
				+  "--------------------------\n"
				+  "       |   (10)   |       \n"
				+  "       +----------+       \n";
		assertEquals(resultadoEsperado, placarTest2.toString());	
	}
	
	@Test
	public void testToString2() {
		placarTest2.add(1, new int[] {1,1,1,1,1});	
		String resultadoEsperado = " 5     |   (7)    |   (4)\n"
				+  "--------------------------\n"
				+  "(2)    |   (8)    |   (5)\n"
				+  "--------------------------\n"
				+  "(3)    |   (9)    |   (6)\n"
				+  "--------------------------\n"
				+  "       |   (10)   |       \n"
				+  "       +----------+       \n";
		assertEquals(resultadoEsperado, placarTest2.toString());	
	}
}
