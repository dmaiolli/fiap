package br.com.fiap.strategy.imposto;

import java.math.BigDecimal;

import br.com.fiap.chainOfResponsability.loja.Pedido;

public class TesteImposto {
	
	public static void main(String[] args) {
		
		CalculadoraDeImposto calcImposto = new CalculadoraDeImposto(new ICMS());
		Pedido ped = new Pedido(new BigDecimal("100"));
		
		BigDecimal imposto = calcImposto.calcular(ped);
		
		System.out.println(imposto);
	}

}
