import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class TestePositivo {

	@Test
	public void testaNroValido() throws IOException {
		Integer resultadoEsperado = 1;
		
		Integer atual = CheckPoint.capturaNro('A');
		
		assertEquals(resultadoEsperado, atual);
	}
}
