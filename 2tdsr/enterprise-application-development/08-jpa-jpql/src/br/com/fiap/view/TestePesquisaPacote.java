package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TestePesquisaPacote {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);

		List<Pacote> pacotes = pacoteDao.todosPacotesPorUmTransporte(transporteDao.pesquisar(1));

		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}

		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
