package br.com.fiap.view;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Combustivel;
import br.com.fiap.entity.Veiculo;

public class AtualizacaoTeste {

	public static void main(String[] args) {

		// obter uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		// Instanciar um objeto veiculo com um código ( transação estado: detached )
		Veiculo veiculo = new Veiculo(1, "HYUNDAI", "PRATA", new GregorianCalendar(2021, 12, 15),
				Combustivel.COMBUSTIVEL, false);

		// Atualizar
		// merge retorna o objeto gerenciado pelo entity manager ( cópia )
		em.merge(veiculo);

		// Começar uma transação
		em.getTransaction().begin();

		// Finalizar
		em.getTransaction().commit();

		// Fechar
		em.close();
		fabrica.close();

	}

}
