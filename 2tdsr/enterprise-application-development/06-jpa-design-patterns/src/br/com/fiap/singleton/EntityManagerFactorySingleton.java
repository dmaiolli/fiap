package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Gerenciar a unica instancia do EntityManagerFactory
 */

public class EntityManagerFactorySingleton {

	// Atributo estático que armazena a unica instancia
	private static EntityManagerFactory fabrica;

	// Método estático que retorna a única instância
	public static EntityManagerFactory getInstance() {

		// Valida se já existe uma instância da fabrica
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}

	// Construtor privado, nenhuma classe consegue instanciar
	private EntityManagerFactorySingleton() {
	}

}
