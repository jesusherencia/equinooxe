package com.equinooxe.domain;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;

import org.springframework.data.elasticsearch.annotations.Document;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.time.ZonedDateTime;

/**
 * A user.
 */
@Entity
@Table(name = "manager_utilisateur")
@DiscriminatorValue("MANAGER")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "manager_utilisateur")
public class ManagerUtilisateur extends User implements Serializable {
	
	@Max(12)
	@Column(name = "age",length=20)
	private String phoneInterne;
	
	
	public String getPhoneInterne() {
		return phoneInterne;
	}



	public void setPhoneInterne(String phoneInterne) {
		this.phoneInterne = phoneInterne;
	}



	@Override
	public String toString() {
		return "AgentUser[ id=" + id + " ]";
	}
}
