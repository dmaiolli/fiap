package br.com.fiap.chainOfResponsability.desconto;

import java.math.BigDecimal;

import br.com.fiap.chainOfResponsability.loja.Pedido;

public class CalculadoraDeDesconto {

	public BigDecimal calcular(Pedido pedido) {

		/*
		 * // Jeito ERRADO
		 * 
		 * // Comparando se o valor do pedido é > 500
		 * if(pedido.getValor().compareTo(new BigDecimal("500")) > 0) { 
		 * Retorno docompareTo: 
		 * pedido < 500 -- -1 
		 * pedido = 500 -- 0 
		 * pedido > 500 -- 1
		 * 
		 * 	return pedido.getValor().multiply(new BigDecimal("0.1")); 
		 * }
		 * 
		 * if(pedido.getQuantidadeDeItens() > 10) { return
		 * pedido.getValor().multiply(new BigDecimal("0.05")); }
		 */
		
		
		// ----------------------------------------------------------------
		// Jeito CERTO
		Desconto cadeiaDeDesconto = 
				new DescontoPorQuantidade(
						new DescontoPorValor(
								new SemDesconto()
				));
		
		return (BigDecimal) cadeiaDeDesconto.calcular(pedido);
	}

}
