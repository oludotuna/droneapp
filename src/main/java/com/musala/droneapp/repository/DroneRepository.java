package com.musala.droneapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musala.droneapp.model.Drone;

@Repository
public interface DroneRepository extends CrudRepository<Drone, Long> {
	@Query(value = "SELECT * FROM drone where id = :id", nativeQuery = true)
	Drone getDroneDetails(Long id);

	@Query(value = "SELECT * FROM drone where state = :state", nativeQuery = true)
	List<Drone> findAvailableDrones(String state);
}
