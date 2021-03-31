package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.impl.VeiculoDaoImpl;
import br.com.fiap.entity.Combustivel;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.VeiculoNotFoundException;

public class VeiculoDaoTeste {

	public static void main(String[] args) throws CommitException, VeiculoNotFoundException {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		VeiculoDaoImpl veiculoDao = new VeiculoDaoImpl(em);

		Veiculo veiculo = new Veiculo("FIAT", "ROXO", new GregorianCalendar(2021, Calendar.APRIL, 1),
				Combustivel.COMBUSTIVEL, false);

		// Cadastrar um veiculo
		try {
			veiculoDao.add(veiculo);
			veiculoDao.commit();
			System.out.println("Veiculo cadastrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Pesquisar um veiculo
		try {
			veiculo = veiculoDao.read(1);
			System.out.println(veiculo);
		} catch (VeiculoNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Atualizar um veiculo
		try {
			veiculo.setCor("PRETO");
			veiculoDao.commit();
			System.out.println("Veiculo alterado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Remover um veiculo
		try {
			veiculoDao.delete(1);
			veiculoDao.commit();
			System.out.println("Veiculo removido");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		} catch (VeiculoNotFoundException e) {
			System.out.println("Veiculo nao existe para remover");
		}

		em.close();
		fabrica.close();
	}
}
