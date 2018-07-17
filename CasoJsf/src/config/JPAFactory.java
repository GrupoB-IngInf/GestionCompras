package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory{

	private static final String PERSISTENCE_UNIT_NAME = "casojpa"; //por que es el nombre de la base de datos

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	//patron Singleton que te permite crear un objeto,no permite que se creen nuevas instancias
	
	public static EntityManager createEntityManager() {

		if (entityManager == null || !entityManager.isOpen()) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

	public static void close() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
