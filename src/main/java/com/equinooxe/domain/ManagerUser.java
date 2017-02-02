package com.equinooxe.domain;

import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.springframework.data.elasticsearch.annotations.Document;
import javax.persistence.*;
import javax.validation.constraints.Max;

/**
 * A user.
 */
@Entity
@Table(name = "manager_utilisateur")
@DiscriminatorValue("MANAGER")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "manager_utilisateur")
public class ManagerUser extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Max(20)
	@Column(name = "phoneInterne", length = 20)
	private String phoneInterne;

	public String getPhoneInterne() {
		return phoneInterne;
	}

	public void setPhoneInterne(String phoneInterne) {
		this.phoneInterne = phoneInterne;
	}

}
