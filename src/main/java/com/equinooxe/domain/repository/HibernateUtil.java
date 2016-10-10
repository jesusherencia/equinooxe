/*
Copyright internet!
 */
package com.equinooxe.domain.repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author mboullouz
 */
public class HibernateUtil {
    
  /**
   * The cached session factory
   */
  private static volatile EntityManager entityManager;

  private HibernateUtil() {
  }

  /**
   * Create the current EntityManager  instance, create a new one when there is none yet.
   * @return The Entity Manager 
   */
  public static synchronized EntityManager getEntityManager() {
    if (entityManager == null) {
      try {
        entityManager = Persistence.createEntityManagerFactory("sbPersistenceUnit").createEntityManager();
      } catch (Throwable ex) {
        System.err.println("Initial entityManager creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
      }
    }
    return entityManager ;
  }

  /**
   * Drop the current connection, resulting in a create-drop clean database next time. This is
   * mainly used for JUnit testing since one test should not influence the other
   */
  public static void closeEntityManager() {
    entityManager.close();
    entityManager = null;
  }
}
