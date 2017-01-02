package com.equinooxe.module.espaces;

public class RemoveFormModel {
	public String postTo;
	public String redirectTo=null;
	public Long id = new Long(-1);
	
	public RemoveFormModel(Long id,String postTo, String redirectTo){
		this.id=id;
		this.postTo = postTo;
		this.redirectTo= redirectTo;
	}

}
