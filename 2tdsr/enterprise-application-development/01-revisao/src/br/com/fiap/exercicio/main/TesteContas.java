package br.com.fiap.exercicio.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.exercicio.bean.ContaCorrente;
import br.com.fiap.exercicio.bean.ContaPoupanca;
import br.com.fiap.exercicio.bean.TipoConta;
import br.com.fiap.exercicio.exception.SaldoInsuficienteException;

public class TesteContas {

	public static void main(String[] args) {

		// EX6
		ContaCorrente cc = new ContaCorrente(1, 324, Calendar.getInstance(), 100.0, TipoConta.COMUM);
		
		ContaPoupanca cp = new ContaPoupanca(1, 1231, new GregorianCalendar(2021, Calendar.APRIL, 1), 200.0, 1f);

		try {
			cc.retirar(100.0);
		} catch (SaldoInsuficienteException e) {
			e.printStackTrace();
		}
		
		// EX7
		List<ContaCorrente> lista = new ArrayList<ContaCorrente>();
		
		lista.add(new ContaCorrente(1, 324, Calendar.getInstance(), 100.0, TipoConta.COMUM));
		lista.add(new ContaCorrente(2, 324, Calendar.getInstance(), 100.0, TipoConta.COMUM));
		lista.add(new ContaCorrente(3, 324, Calendar.getInstance(), 100.0, TipoConta.COMUM));
		
		for (ContaCorrente c : lista) {
			System.out.println(c.getSaldo());
		}
		
	}

}
