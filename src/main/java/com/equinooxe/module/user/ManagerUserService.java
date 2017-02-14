package com.equinooxe.module.user;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equinooxe.domain.Authority;
import com.equinooxe.domain.ManagerUser;
import com.equinooxe.repository.AuthorityRepository;
import com.equinooxe.repository.ManagerUserQueryRepository;
import com.equinooxe.repository.ManagerUserRepository;
import com.equinooxe.security.AuthoritiesConstants;
import com.equinooxe.service.util.RandomUtil;

@Service
@Transactional
public class ManagerUserService {
	@Inject
	private ManagerUserRepository managerUserRepo;
	@Autowired
	ManagerUserQueryRepository managerUserQueryRepo;
	@Inject
	AuthorityRepository authorityRepo;
	@Inject
	private PasswordEncoder passwordEncoder;

	public ManagerUser updateUserFrom(ManagerUserForm managerUserForm) {
		ManagerUser user = managerUserQueryRepo.getOneById(managerUserForm.getId());
		user.setFirstName(managerUserForm.getFirstName());
		user.setEmail(managerUserForm.getEmail());
		user.setLastName(managerUserForm.getLastName());
		user.setLogin(managerUserForm.getLogin());
		if (managerUserForm.getPassword() != null && managerUserForm.getPassword().length() >= 4) {
			user.setPassword(managerUserForm.getPassword());
		}
		Set<Authority> selectedAut = new HashSet<>();
		for (String authName : managerUserForm.getAutorities()) {
			if (authName != null && authName.length() > 1) {
				selectedAut.add(authorityRepo.findOne(authName));
			}
		}
		user.setAuthorities(selectedAut);
		managerUserRepo.saveAndFlush(user);
		return user;
	}
	public ManagerUser createManagerUser(String login, String password, String firstName, String lastName, String email,
			String langKey, boolean activate) {

		ManagerUser newUser = new ManagerUser();
		Authority authority = authorityRepo.findOne(AuthoritiesConstants.USER);
		Set<Authority> authorities = new HashSet<>();
		String encryptedPassword = passwordEncoder.encode(password);
		newUser.setLogin(login);
		// new user gets initially a generated password
		newUser.setPassword(encryptedPassword);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmail(email);
		newUser.setLangKey(langKey);
		// new user is not active
		newUser.setActivated(activate);
		// new user gets registration key
		newUser.setActivationKey(RandomUtil.generateActivationKey());
		authorities.add(authority);
		newUser.setAuthorities(authorities);
		managerUserRepo.save(newUser);
		return newUser;
	}
}
