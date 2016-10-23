package com.equinooxe.domain.repository;

import com.equinooxe.domain.CleanRequest;
 

public interface CleanRequestRepository extends Repository<CleanRequest> {

	public CleanRequest createCleanRequest(CleanRequest cleanRequest);
}
