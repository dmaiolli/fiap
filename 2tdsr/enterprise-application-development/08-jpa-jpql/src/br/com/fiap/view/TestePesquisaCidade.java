package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TestePesquisaCidade {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		CidadeDAO cidadeDao = new CidadeDAOImpl(em);

		List<Cidade> cidades = cidadeDao.listar();
		
		for(Cidade cidade : cidades) {
			System.out.println(cidade.getNome() + " - " + cidade.getUf());
		}
		
		List<Cidade> cidadesMaiorQue1000Habitantes = cidadeDao.buscaPorNumeroHabitantesMaior(1000);
		
		for(Cidade cidade : cidadesMaiorQue1000Habitantes) {
			System.out.println(cidade.getNome() + " - " + cidade.getNrHabitantes());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
