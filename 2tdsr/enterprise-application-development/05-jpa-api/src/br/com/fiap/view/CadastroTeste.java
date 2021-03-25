package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Combustivel;
import br.com.fiap.entity.Veiculo;

public class CadastroTeste {

	public static void main(String[] args) {

		// Obter uma instância da fabrica e do entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		// Instanciar um veiculo sem o código (estado transação: new, não gerenciado)
		Veiculo veiculo = new Veiculo("FIAT", "ROXO", new GregorianCalendar(2021, Calendar.APRIL, 1),
				Combustivel.COMBUSTIVEL, false);

		// Cadastrar o veiculo
		// Passar o objeto veiculo para o entity manager gerenciar
		em.persist(veiculo);
		
		// Começar uma transação
		em.getTransaction().begin();

		// Finalizar
		em.getTransaction().commit();

		// Se alterarmos, ele mudará no banco tambem, pois ele é gerenciador desse objeto
		veiculo.setCor("Branco");

		em.getTransaction().begin();
		em.getTransaction().commit();

		// Fechar
		em.close();
		fabrica.close();

	}

}
