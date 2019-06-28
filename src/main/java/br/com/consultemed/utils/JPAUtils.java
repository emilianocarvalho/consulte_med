package br.com.consultemed.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtils {

	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();

	private static EntityManagerFactory entityManagerFactory;

	private JPAUtils() {
	}

	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT_NAME);
		}

		EntityManager entityManager = threadEntityManager.get();

		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = entityManagerFactory.createEntityManager();
			JPAUtils.threadEntityManager.set(entityManager);
		}

		return entityManager;

	}

	public static void closeEntityManager() {
		EntityManager em = threadEntityManager.get();

		if (em != null) {
			EntityTransaction transaction = em.getTransaction();

			if (transaction.isActive()) {
				transaction.commit();
			}

			em.close();

			threadEntityManager.set(null);
		}
	}

	public static void closeEntityManagerFactory() {
		closeEntityManager();
		entityManagerFactory.close();
	}

}
