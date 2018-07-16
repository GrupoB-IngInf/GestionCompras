package base;

import javax.persistence.EntityManager;

import config.JPAFactory;

public class JPA extends JPAFactory {

	public EntityManager getEntityManager() {
		return JPAFactory.createEntityManager();
	}
	
	public void closeEntityManager() {
		JPAFactory.close();
	}
	
}
