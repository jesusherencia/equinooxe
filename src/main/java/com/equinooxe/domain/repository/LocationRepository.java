package com.equinooxe.domain.repository;

import com.equinooxe.domain.Location;
import com.equinooxe.domain.User;

public interface LocationRepository extends Repository<Location> {

	public User createLocation(Location location);
}
