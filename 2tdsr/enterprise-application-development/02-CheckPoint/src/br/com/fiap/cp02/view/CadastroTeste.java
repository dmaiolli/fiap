package br.com.fiap.cp02.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.cp02.dao.MotoristaDao;
import br.com.fiap.cp02.dao.impl.MotoristaDaoImpl;
import br.com.fiap.cp02.entity.Corrida;
import br.com.fiap.cp02.entity.Habilitacao;
import br.com.fiap.cp02.entity.Motorista;
import br.com.fiap.cp02.entity.Pessoa;
import br.com.fiap.cp02.entity.TipoHabilitacao;
import br.com.fiap.cp02.exception.CommitException;
import br.com.fiap.cp02.singleton.EntityManagerFactorySingleton;

/*
 * Cadastro sendo realizado com Cascade pela entidade Motorista que possui a chave estrangeira de Habilitacao
 * no relacionamento 1:1.
 */
public class CadastroTeste {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		MotoristaDao motoristaDao = new MotoristaDaoImpl(em);
		
		Habilitacao habilitacao = new Habilitacao(new GregorianCalendar(2022, Calendar.AUGUST, 22), TipoHabilitacao.CARRO);

		Motorista motorista = new Motorista("Abreu", 12345567899L, habilitacao);
		
		Corrida corrida = new Corrida(20.00);
		Corrida corrida2 = new Corrida(22.50);
		Corrida corrida3 = new Corrida(33.96);
		
		motorista.addCorrida(corrida);
		motorista.addCorrida(corrida2);
		motorista.addCorrida(corrida3);
		
		Pessoa pessoa = new Pessoa("José", 11962323433L, "jose@jose.com");
		Pessoa pessoa2 = new Pessoa("Maria", 11983224233L, "maria@maria.com");
		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(pessoa);
		pessoas.add(pessoa2);
		
		corrida.setPessoas(pessoas);
		corrida2.setPessoas(pessoas);
		
		motoristaDao.inserir(motorista);
		
		try {
			motoristaDao.commit();
			System.out.println("Cadastro concluído com sucesso!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}