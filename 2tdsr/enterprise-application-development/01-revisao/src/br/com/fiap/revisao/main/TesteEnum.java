package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Funcionario;
import br.com.fiap.revisao.bean.Genero;

public class TesteEnum {
	
	public static void main(String[] args) {
		
		Funcionario func = new Funcionario();
		
		func.setGenero(Genero.MASCULINO);
		
		if (func.getGenero() == Genero.FEMININO) {
			System.out.println("Feminino");
		}
		
		System.out.println(func.getGenero());
		
	}
	
	

}
