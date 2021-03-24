package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Veiculo;

public class RemoverTeste {

	public static void main(String[] args) {
		// Obter uma instância da fabrica e do entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		// Recuperando veiculo a ser removido
		Veiculo veiculo = em.find(Veiculo.class, 1);

		// Excluindo o veiculo
		em.remove(veiculo);
		
		em.getTransaction().begin();
		em.getTransaction().commit();

		// Fechar
		em.close();
		fabrica.close();

	}

}
