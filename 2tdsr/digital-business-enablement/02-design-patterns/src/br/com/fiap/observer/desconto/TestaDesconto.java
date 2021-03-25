package br.com.fiap.observer.desconto;

import java.math.BigDecimal;

import br.com.fiap.templateMethod.loja.Pedido;

public class TestaDesconto {

	public static void main(String[] args) {

		CalculadoraDeDesconto calcDesconto = new CalculadoraDeDesconto();
		Pedido ped = new Pedido(new BigDecimal("100"));
		Pedido pedido = new Pedido(new BigDecimal("600"), 20);

		BigDecimal desconto = calcDesconto.calcular(ped);
		BigDecimal descontoo = calcDesconto.calcular(pedido);

		System.out.println(desconto);
		System.out.println(descontoo);
		
		for ( int i = 1 ; i <= 100; i++ ) { 
			   if ( ( i %  3 ) == 0 ) {
			      System.out.println("Fizz");
			   }

			   else if ( ( i % 5 ) == 0 ) {
			     System.out.println("Buzz");
			  }

			  else if ( ( i % 3 ) == 0 && ( i % 5 ) == 0 ) { 
			    System.out.println("FizzBuzz");
			 }

			 else { 
			  System.out.println(i);
			}
			}

	}
}
