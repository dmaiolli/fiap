package br.com.fiap.view;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoChallengeDao;
import br.com.fiap.dao.ProjetoChallengeDao;
import br.com.fiap.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.GrupoChallenge;
import br.com.fiap.entity.NanoCourses;
import br.com.fiap.entity.NivelCurso;
import br.com.fiap.entity.ProjetoChallenge;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		
		// Obter o entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		

		// obter um GrupoChallengeDao e o ProjetoChallengeDao
		GrupoChallengeDao grupoDao = new GrupoChallengeDaoImpl(em);
		ProjetoChallengeDao projetoDao = new ProjetoChallengeDaoImpl(em);
		
		// Instanciar um Grupo
		GrupoChallenge grupo = new GrupoChallenge("QuarenT.I");
		
		// Instanciar um Projeto
		ProjetoChallenge projeto = new ProjetoChallenge(
				"letme.Walk", new GregorianCalendar(2021, 12, 5), null, "Acessibilidade", grupo);
		
		// Cadastrar um grupo
		grupoDao.create(grupo);
		
		// Instanciar 2 alunos e adicionar no grupo
		Aluno aluno1 = new Aluno("Denys", new GregorianCalendar(2001, 12, 17), Genero.MASCULINO);
		Aluno aluno2 = new Aluno("Juan", new GregorianCalendar(2002, 8, 13), Genero.MASCULINO);
		Aluno aluno3 = new Aluno("Victor", new GregorianCalendar(2008, 2, 35), Genero.FEMININO);
		
		grupo.addAluno(aluno1);
		grupo.addAluno(aluno2);
		grupo.addAluno(aluno3);
		

		// Cadastrar 2 cursos relacionados com os alunos
		NanoCourses nano1 = new NanoCourses("Java Fundamentos", 8, NivelCurso.BASICO);
		NanoCourses nano2 = new NanoCourses("Linux Fundamentos", 4, NivelCurso.BASICO);

		// Instanciar uma lista de cursos e adicionar os cursos na lista
		List<NanoCourses> cursos = new ArrayList<NanoCourses>();
		cursos.add(nano1);
		cursos.add(nano2);
		
		// Setar a lista de curso no aluno
		aluno1.setCursos(cursos);
		aluno2.setCursos(cursos);

		// Cadastrar um projeto
		projetoDao.create(projeto);
		
		// Commit
		try {
			// Como compartilham o mesmo entity manager, se eu der commit ja irá cadastrar os dois
			projetoDao.commit();
			System.out.println("Grupo e projeto cadastrados!");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
}
