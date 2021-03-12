import static org.junit.Assert.*;

import org.junit.Test;

public class TesteMensagens {
	
	@Test
	public void testeExibeMensagem() {
		String mensagem = "Olá, testando";
		String resultadoEsperado = mensagem;
		
		BoasVindas boasv = new BoasVindas(mensagem);
		
		boasv.exibirMenssagem();
		assertEquals(resultadoEsperado, mensagem);
	}
	
	@Test
	public void testeCompletaMensagem() {
		BoasVindas boasv = new BoasVindas();

		String mensagemEsperada = "Ola! Seja bem vindo a sua calculadora pessoal";
		String mensagem = boasv.completarMenssagem();

		assertEquals(mensagemEsperada, mensagem);
	}

}