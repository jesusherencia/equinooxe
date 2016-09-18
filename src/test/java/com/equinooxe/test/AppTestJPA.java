package com.equinooxe.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.datanucleus.util.NucleusLogger;

import com.equinooxe.domain.User;

import junit.framework.TestCase;

public class AppTestJPA extends TestCase {

	EntityManagerFactory entityManagerFactory;

	protected void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory( "sbPersistenceUnit" );
	}

	public void testAddUser() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			entityManager.persist( new User("a", "a@a.com", "a") );
			entityManager.persist( new User("b", "b@b.com", "b") );
			tx.commit();
		} catch (Exception e) {
            NucleusLogger.GENERAL.error(">> Exception persisting data", e);
            System.err.println("Error persisting data : " + e.getMessage());
            return;
        } finally {
            if (tx.isActive())
            {
                tx.rollback();
            }
            entityManager.close();
        }
	}
}
