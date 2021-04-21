package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProjetoChallengeDao;
import br.com.fiap.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.NanoCourses;
import br.com.fiap.entity.ProjetoChallenge;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		ProjetoChallengeDao projetoDao = new ProjetoChallengeDaoImpl(em);

		try {
			ProjetoChallenge projeto = projetoDao.read(1);

			System.out.println("Projeto " + projeto.getNomeProjeto());

			System.out.println("Grupo " + projeto.getGrupo().getNomeGrupo());

			List<Aluno> alunos = projeto.getGrupo().getAlunos();
			for (Aluno aluno : alunos) {
				System.out.println(aluno.getNomeAluno());
				// Exibir os cursos relacionados ao aluno
				System.out.println("Cursos realizados: ");
				for (NanoCourses curso : aluno.getCursos()) {
					System.out.println(curso);
				}
			}

		} catch (br.com.fiap.tds.exception.EntityNotFoundException e) {
			e.printStackTrace();
		}

		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
