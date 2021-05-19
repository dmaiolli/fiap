package br.com.fiap.cp02.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.cp02.dao.CorridaDao;
import br.com.fiap.cp02.dao.HabilitacaoDao;
import br.com.fiap.cp02.dao.MotoristaDao;
import br.com.fiap.cp02.dao.PessoaDao;
import br.com.fiap.cp02.dao.impl.CorridaDaoImpl;
import br.com.fiap.cp02.dao.impl.HabilitacaoDaoImpl;
import br.com.fiap.cp02.dao.impl.MotoristaDaoImpl;
import br.com.fiap.cp02.dao.impl.PessoaDaoImpl;
import br.com.fiap.cp02.entity.Corrida;
import br.com.fiap.cp02.entity.Habilitacao;
import br.com.fiap.cp02.entity.Motorista;
import br.com.fiap.cp02.entity.Pessoa;
import br.com.fiap.cp02.entity.TipoHabilitacao;
import br.com.fiap.cp02.exception.CommitException;
import br.com.fiap.cp02.exception.EntityNotFoundException;
import br.com.fiap.cp02.singleton.EntityManagerFactorySingleton;

public class CadastroTeste3 {
	
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		HabilitacaoDao habilitacaoDao = new HabilitacaoDaoImpl(em);
		Habilitacao habilitacao = new Habilitacao(new GregorianCalendar(2025, Calendar.AUGUST, 15), TipoHabilitacao.CARRO);
		try {
			habilitacaoDao.inserir(habilitacao);
			habilitacaoDao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		PessoaDao pessoaDao = new PessoaDaoImpl(em);
		Pessoa pessoa = new Pessoa("Josue", 11962323433L, "josue@jose.com");
		Pessoa pessoa2 = new Pessoa("Maria", 11983224233L, "ma  ria@maria.com");
		try {
			pessoaDao.inserir(pessoa);
			pessoaDao.inserir(pessoa2);
			pessoaDao.commit();
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		
		CorridaDao corridaDao = new CorridaDaoImpl(em);
		Corrida corrida1 = new Corrida(15.90);
		Corrida corrida2 = new Corrida(80.17);
		try {
			Pessoa pessoa3 = pessoaDao.consultar(1);
			Pessoa pessoa4 = pessoaDao.consultar(2);
			
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			pessoas.add(pessoa3);
			
			corrida1.setPessoas(pessoas);
			
			pessoas.add(pessoa4);
			corrida2.setPessoas(pessoas);
			
			corridaDao.inserir(corrida1);
			corridaDao.inserir(corrida2);
			corridaDao.commit();
		} catch (CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		MotoristaDao motoristaDao = new MotoristaDaoImpl(em);
		Motorista motorista = new Motorista("Thiago", 1794556785L);
		try {
			habilitacao = habilitacaoDao.consultar(1);
			motorista.setHabilitacao(habilitacao);
			
			corrida1 = corridaDao.consultar(1);
			corrida2 = corridaDao.consultar(2);
			
			List<Corrida> corridas = new ArrayList<Corrida>();
			corridas.add(corrida1);
			corridas.add(corrida2);
			
			motorista.setCorridas(corridas);
			
			motoristaDao.inserir(motorista);
			motoristaDao.commit();
		} catch (CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
