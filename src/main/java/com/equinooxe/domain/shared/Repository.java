package com.equinooxe.domain.shared;

import java.util.List;

public interface Repository<T> {

	public T findById(Long id);
	
	public List<T> findAll();
	
	public T add(T t);
	
	public boolean remove(T t);
	
}
