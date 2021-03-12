import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCalculadoraSubtracao {

	@Test
	public void testeCalculadoraSubtrai5com3() {
		int n1 = 5;
		int n2 = 3;
		int resultadoEsperado = n1 - n2;
		
		Calculadora calc = new Calculadora();
		int resultadoReal = calc.subtrair(n1, n2);
		
		assertEquals(resultadoEsperado, resultadoReal);
	}

}
