package com.equinooxe.module.common;

import com.equinooxe.domain.util.EqUtils;

public abstract class BaseFormModel {
	protected Long id = new Long(-1);
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return EqUtils.json(this);
	}
}
