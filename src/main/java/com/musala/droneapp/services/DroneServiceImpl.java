package com.musala.droneapp.services;

import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.droneapp.enums.StateEnum;
import com.musala.droneapp.model.Drone;
import com.musala.droneapp.model.Medication;
import com.musala.droneapp.repository.DroneRepository;

/**
 * @author AAdigun
 *
 */

@Service
public class DroneServiceImpl implements DroneService {
	
	@Autowired
	private DroneRepository droneRepository;
	
	@Override
	public Drone registerDrone(Drone drone) {
		return droneRepository.save(drone);
	}
	
	@Override
	public String loadDrone(Long droneId, Set<Medication> medications) {
		Drone drone = droneRepository.getDroneDetails(droneId);
		if (drone.getBatteryCapacity() < 25)
			return new JSONObject()
					.put("message", "Drone cannot be loaded because battery capacity is currently below 25%.")
					.toString();

		drone.setState(StateEnum.LOADING);
		droneRepository.save(drone);

		double cargoWeight = 0;
		for (Medication medication : medications) {
			cargoWeight += medication.getWeight();
		}

		if (cargoWeight > drone.getWeightLimit())
			return new JSONObject().put("message", "Drone cannot be loaded because medication weight of " + cargoWeight
					+ "g exceeds drones' " + drone.getWeightLimit() + "g capacity.").toString();

		drone.setMedications(medications);
		drone.setState(StateEnum.LOADED);
		droneRepository.save(drone);

		return new JSONObject().put("message", "Drone loaded successfully.").toString();
	}

	@Override
	public Set<Medication> getLoadedMedication(Long droneId) {
		Drone drone = droneRepository.getDroneDetails(droneId);
		return drone.getMedications();
	}
	
	@Override
	public List<Drone> getAvailableDrones() {
		return droneRepository.findAvailableDrones(String.valueOf(StateEnum.IDLE));
	}

	@Override
	public double checkDroneBatteryLevel(Long droneId) {
		Drone drone = droneRepository.getDroneDetails(droneId);
		return drone.getBatteryCapacity();
	}
}
