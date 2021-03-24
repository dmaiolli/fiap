package br.com.fiap.view;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Combustivel;
import br.com.fiap.entity.Veiculo;

public class Refresh {

	// Atualiza o objeto com os dados do banco
	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		// pesquisar um veiculo de código 1
		Veiculo veiculo = em.find(Veiculo.class, 1);

		// Exibir os dados do veiculo
		System.out.println(veiculo + "\n\n");

		// alterar a marca e a cor no objeto
		veiculo.setCor("BRONZZE");

		// exibir os dados do veiculo
		System.out.println(veiculo + "\n\n");
		
		// realizar o refresh
		em.refresh(veiculo);

		// exibir os dados do veiculo
		System.out.println(veiculo + "\n\n");

		// fecar

		em.close();
		fabrica.close();

	}

}
