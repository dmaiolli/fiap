package br.com.fiap.strategy.imposto;

import java.math.BigDecimal;

import br.com.fiap.chainOfResponsability.loja.Pedido;

public class CalculadoraDeImposto {
	
	private Imposto imposto;
	
	public CalculadoraDeImposto(Imposto imposto) {
		super();
		this.imposto = imposto;
	}

	public BigDecimal calcular(Pedido pedido) {
		// ICMS 10% 
		// ISS 5%
		// IPI 4%
		
		/* A principio fariamos dessa forma sem aplicar o design pattern, que não é uma boa prática
		 * 
		 * if(imposto.equals(ICMS)) {
		 * 		return pedido.getValor().multiply(New BigDecimal("0.1"));
		 * 
		 * } else if(imposto.equals(ISS)) {
		 * 		return pedido.getValor().multiply(New BigDecimal("0.05"));
		 * 	
		 * } else if(imposto.equals(IPI)) {
		 * 		return pedido.getValor().multiply(New BigDecimal("0.04"));
		 * }
		 * return 0;
		 */
		
		
		// Aplicando a estratégia de Strategy o código ficará assim, com a criação da interface Imposto e dos métodos
		// ICMS, IPI, ISS
		return imposto.calcular(pedido);
	}
	
	public Imposto getImposto() {
		return imposto;
	}

	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}
	
}
