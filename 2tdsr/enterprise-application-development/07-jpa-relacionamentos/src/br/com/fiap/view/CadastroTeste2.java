package br.com.fiap.view;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.CursoDao;
import br.com.fiap.dao.GrupoChallengeDao;
import br.com.fiap.dao.ProjetoChallengeDao;
import br.com.fiap.dao.impl.AlunoDaoImpl;
import br.com.fiap.dao.impl.CursoDaoImpl;
import br.com.fiap.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.GrupoChallenge;
import br.com.fiap.entity.NanoCourses;
import br.com.fiap.entity.ProjetoChallenge;
import br.com.fiap.tds.entity.Curso;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste2 {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		// Cadastrar um grupo
		GrupoChallengeDao grupoDao = new GrupoChallengeDaoImpl(em);
		GrupoChallenge grupo = new GrupoChallenge("ECOLOGYK");

		try {
			grupoDao.create(grupo);
			grupoDao.commit();
			System.out.println("Grupo cadastrado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Cadastrar um projeto associado a um grupo que existe no banco
		ProjetoChallengeDao projetoDao = new ProjetoChallengeDaoImpl(em);

		try {
			grupo = grupoDao.read(2);

			ProjetoChallenge projeto = new ProjetoChallenge("WALKER", Calendar.getInstance(), 10.0f, "Saude", grupo);

			projetoDao.create(projeto);
			projetoDao.commit();
			System.out.println("Projeto cadastrado");
			
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}

		// Cadastrar um aluno associado a um grupo que existe no banco
		AlunoDao alunoDao = new AlunoDaoImpl(em);

		try {
			grupo = grupoDao.read(2);
			
			Aluno aluno = new Aluno("Denys", Calendar.getInstance(), Genero.MASCULINO, grupo);
			
			alunoDao.create(aluno);
			alunoDao.commit();
			System.out.println("Aluno cadastrado");
			
		} catch(EntityNotFoundException | CommitException e ) {
			System.out.println(e.getMessage());
		}
		
		// Associar um aluno a um curso que já existem no banco
		CursoDao cursoDao = new CursoDaoImpl(em);
		
		try {
			NanoCourses curso = cursoDao.read(1);
			
			Aluno aluno1 = alunoDao.read(1);
			
			aluno1.getCursos().add(curso);
			
			alunoDao.update(aluno1);
			alunoDao.commit();
			
		} catch ( CommitException | EntityNotFoundException e ) {
			System.out.println(e.getMessage());
		}

	}

}
