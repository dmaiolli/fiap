package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Veiculo;

public class PesquisaTeste {

	public static void main(String[] args) {
		// Obter a fábrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		// Pesquisar veiculo pela PK
		// Retorna um objeto gerenciado ou null
		Veiculo veiculo = em.find(Veiculo.class, 1);

		// Exibindo os dados do veículo
		System.out.println(veiculo);
		
		// Fechar
		em.close();
		fabrica.close();

	}

}
