package com.equinooxe.domain.repository;

import com.equinooxe.domain.CleanRequest;
import com.equinooxe.domain.User;
import com.equinooxe.domain.shared.Repository;

public interface CleanRequestRepository extends Repository<CleanRequest> {

	public User createCleanRequest(CleanRequest cleanRequest);
}
