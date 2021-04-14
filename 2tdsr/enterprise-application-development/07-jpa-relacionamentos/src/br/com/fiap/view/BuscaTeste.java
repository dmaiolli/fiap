package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProjetoChallengeDao;
import br.com.fiap.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.entity.ProjetoChallenge;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		ProjetoChallengeDao projetoDao = new ProjetoChallengeDaoImpl(em);

		try {
			ProjetoChallenge projeto = projetoDao.read(1);
			
			System.out.println(projeto.getNomeProjeto());

			System.out.println(projeto.getGrupo().getNomeGrupo());
		} catch (br.com.fiap.tds.exception.EntityNotFoundException e) {
			e.printStackTrace();
		}

		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
