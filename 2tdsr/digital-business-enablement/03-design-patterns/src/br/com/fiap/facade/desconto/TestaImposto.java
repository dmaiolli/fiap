package br.com.fiap.facade.desconto;

public class TestaImposto {
	
	public static void main(String[] args) {
		
		CalculadoraDeImposto calcImposto = new CalculadoraDeImposto(new ICMS(new ISS(new IPI(null))));
	}

}
