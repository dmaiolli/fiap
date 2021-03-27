import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class TesteNegativo {
	
	@Test
	public void testaNroInvalido() throws IOException {
		Integer resultadoEsperado = 2;
		
		Integer resultadoAtual = CheckPoint.capturaNro('A');
		
		assertEquals(resultadoEsperado, resultadoAtual);
	}
}
