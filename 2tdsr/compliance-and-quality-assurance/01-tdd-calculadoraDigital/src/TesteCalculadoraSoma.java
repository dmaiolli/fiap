import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCalculadoraSoma {

	@Test
	public void testeCalculadoraSoma2com3() {
		int n1 = 2;
		int n2 = 3;
		int resultEsperado = 5;
		
		Calculadora calc = new Calculadora();
		
		int resultadoReal = calc.somar(n1, n2);
		
		assertEquals(resultEsperado, resultadoReal);
	}

	@Test
	public void testeCalculadoraSoma50com3() {
		int n1 = 50;
		int n2 = 3;
		int resultEsperado = n1 + n2;
		
		Calculadora calc = new Calculadora();
		
		int resultadoReal = calc.somar(n1, n2);
		
		assertEquals(resultEsperado, resultadoReal);
	}
}
