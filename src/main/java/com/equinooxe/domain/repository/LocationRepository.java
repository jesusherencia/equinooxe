package com.equinooxe.domain.repository;

import com.equinooxe.domain.Location;
import com.equinooxe.domain.User;
import com.equinooxe.domain.shared.Repository;

public interface LocationRepository extends Repository<Location> {

	public User createLocation(Location location);
}
