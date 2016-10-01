package com.equinooxe.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.datanucleus.util.NucleusLogger;

import com.equinooxe.domain.Permission;
import com.equinooxe.domain.User;
import com.equinooxe.domain.repository.UserRepository;

public class UserJpaRepository implements UserRepository {

	EntityManagerFactory entityManagerFactory;
	
	public UserJpaRepository() {
		super();
		entityManagerFactory = Persistence.createEntityManagerFactory( "sbPersistenceUnit" );
	}

	public User findById(Integer id) {
		// TODO Auto-generated method stub
		/*for (User u : list) {
			if(u.getUserId().equals(id)) {
				return u;
			}
		}*/
		return null;
	}
	
	public User findUserByEmail(String email) {
		EntityManager em = entityManagerFactory.createEntityManager();
		User user = (User) em.createQuery("Select u From User as u Where u.email= :email")
                .setParameter("email", email)
                .getSingleResult();
		return null;
	}
	
	public User findUserByUsername(String username) {
		EntityManager em = entityManagerFactory.createEntityManager();
		User user = (User) em.createQuery("Select u From User as u Where u.username= :username")
                .setParameter("username", username)
                .getSingleResult();
		return user;
	}

	public List<User> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<User> result = new ArrayList<User>();
		try {
			tx.begin();
			//List<User> result = getSession().createQuery("from User").getResultList();
			Query q = em.createQuery("from User");
			result = q.getResultList();
			tx.commit();
		} catch (Exception e) {
            NucleusLogger.GENERAL.error(">> Exception persisting data", e);
            System.err.println("Error persisting data : " + e.getMessage());
            return result;
        } finally {
            if (tx.isActive())
            {
                tx.rollback();
            }
            em.close();
        }
		return result;
	}

	public User add(User t) {
		// TODO Auto-generated method stub
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(t);
			tx.commit();
		} catch (Exception e) {
            NucleusLogger.GENERAL.error(">> Exception persisting data", e);
            System.err.println("Error persisting data : " + e.getMessage());
            return null;
        } finally {
            if (tx.isActive())
            {
                tx.rollback();
            }
            em.close();
        }
		return t;
	}

	public boolean remove(User t) {
		// TODO Auto-generated method stub
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(t);
			tx.commit();
		} catch (Exception e) {
            NucleusLogger.GENERAL.error(">> Exception persisting data", e);
            System.err.println("Error persisting data : " + e.getMessage());
            return false;
        } finally {
            if (tx.isActive())
            {
                tx.rollback();
            }
            em.close();
        }
		return true;
	}

	public User createUser(String email, String username, String password) {
		User user = new User();
        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
        Object salt = rng.nextBytes();
        String hashedPasswordBase64 = new Sha256Hash(password, salt, 1024).toBase64();
        user.setPassword(hashedPasswordBase64);
        user.setSalt(salt.toString());
        user.setEmail(username);
        user.setUsername(username);
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
	        em.persist(user);
	        tx.commit();
		} catch (Exception e) {
            NucleusLogger.GENERAL.error(">> Exception persisting data", e);
            System.err.println("Error persisting data : " + e.getMessage());
            return null;
        } finally {
            if (tx.isActive())
            {
                tx.rollback();
            }
            em.close();
        }
        return user;
	}
	
	public List<Permission> getAllByRoleName(String roleName) {
        List<Permission> permissions;
        EntityManager em = entityManagerFactory.createEntityManager();
        permissions= em.createQuery(" SELECT P FROM Permission as P, Role as R, RolePermission as RP  WHERE RP.role.id = R.id AND RP.permission.id=P.id AND R.name= :roleName ")
                    .setParameter("roleName", roleName).getResultList();
        return permissions;
    }

}
