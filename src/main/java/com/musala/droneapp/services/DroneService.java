package com.musala.droneapp.services;

import java.util.List;
import java.util.Set;

import com.musala.droneapp.model.Drone;
import com.musala.droneapp.model.Medication;

public interface DroneService {

	String loadDrone(Long droneId, Set<Medication> medications);

	Set<Medication> getLoadedMedication(Long droneId);

	List<Drone> getAvailableDrones();

	double checkDroneBatteryLevel(Long droneId);

	Drone registerDrone(Drone drone);
	

}
