package com.equinooxe.domain.repository;

import com.equinooxe.domain.CleanRequest;
import com.equinooxe.domain.User;

public interface CleanRequestRepository extends Repository<CleanRequest> {

	public User createCleanRequest(CleanRequest cleanRequest);
}
