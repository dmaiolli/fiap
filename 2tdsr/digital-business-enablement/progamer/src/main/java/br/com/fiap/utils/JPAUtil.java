package br.com.fiap.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("progamer-persistence-unit");
	EntityManager manager = FACTORY.createEntityManager();
	private static EntityManager manager;
	
	public static EntityManager getEntityManager() {
		if(manager == null) {
			manager = FACTORY.createEntityManager();
		}
	}
	
	
}