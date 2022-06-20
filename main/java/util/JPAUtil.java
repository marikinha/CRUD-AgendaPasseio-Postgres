package util;

import javax.persistence.EntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AP1DACPU");
	
	public static EntityManager criarEntityManager() {
		
	return emf.createEntityManager();

	}
}
