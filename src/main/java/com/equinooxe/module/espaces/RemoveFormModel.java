package com.equinooxe.module.espaces;

public class RemoveFormModel {
	private String postTo;
	private String redirectTo;
	private Long id = new Long(-1);
	
	public RemoveFormModel() {
		/* */
	}
	
	public RemoveFormModel(Long id,String postTo, String redirectTo){
		this.id=id;
		this.postTo = postTo;
		this.redirectTo= redirectTo;
	}
	
	public String toString(){
		return "{"
				+"id:"+id
				+"redirectTo"+redirectTo
				+"}";
	}

	public String getPostTo() {
		return postTo;
	}

	public void setPostTo(String postTo) {
		this.postTo = postTo;
	}

	public String getRedirectTo() {
		return redirectTo;
	}

	public void setRedirectTo(String redirectTo) {
		this.redirectTo = redirectTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
