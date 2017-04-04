package com.equinooxe.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equinooxe.domain.ManagerUser;
import com.equinooxe.domain.QManagerUser;
import com.equinooxe.security.SecurityUtils;

/**
 * 
 * @author mboullouz
 *
 */
@Component
public class ManagerUserQueryRepository extends AbstractQueryRespository<QManagerUser,ManagerUser> {
	
	@Inject
	private UserRepository userRepository;
	
	@Autowired
	public ManagerUserQueryRepository(EntityManager entityManager) {
		super(entityManager,QManagerUser.managerUser);
	}

	public ManagerUser getOneById(Long id) {
		ManagerUser u = queryFactory.selectFrom(qEntity).where(qEntity.id.eq(id)).fetchOne();
		return u;
	}
	
	@Override
	public List<ManagerUser> getAll() {
		return queryFactory.selectFrom(qEntity).innerJoin(qEntity.authorities).fetch();
	}
	
	public ManagerUser getCurrent() {
		String userName= SecurityUtils.getCurrentUserLogin();
		userRepository.findAll().forEach(u-> {
			if(u.getLogin().contains(userName)) {
				System.out.println("\n =================== \n Waw found: "+ u.getId()+ " "+ u.getEmail());
			}
			else {
				System.out.println("\n ================= \n nop :: "+ u.getLogin()+" :: "+ u.getId()+ " :: "+ u.getEmail());
			}
			
		});
	    return queryFactory.selectFrom(qEntity).where(qEntity.login.eq(userName)).fetchOne();
	}
	
}
