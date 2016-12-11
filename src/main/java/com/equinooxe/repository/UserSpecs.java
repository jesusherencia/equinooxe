package com.equinooxe.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.springframework.data.jpa.domain.Specification;

import com.equinooxe.domain.User;

public class UserSpecs {
	public static Specification<User> firstRecord() {
		return new Specification<User>() {
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				EntityType<User> userModel = root.getModel();
				return builder.equal(root.get(userModel.getSingularAttribute("id", Long.class)), new Long(1));
			}
		};
	}
}
