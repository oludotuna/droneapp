package com.musala.droneapp.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musala.droneapp.model.Drone;
import com.musala.droneapp.model.Medication;
import com.musala.droneapp.services.DroneService;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class DroneResource {
	private static Logger logger = LoggerFactory.getLogger(DroneResource.class);
	
	@Autowired
	private DroneService droneService;
	
	@PostMapping("/register")
	public Drone registerDrone(@Valid @RequestBody Drone drone, Errors errors) {
		if (errors.hasErrors()) {
			logger.info("Error: " + errors.toString());
			return new Drone();
		} else {
			return droneService.registerDrone(drone);
		}
	}

	@PostMapping("/load/{droneId}")
	public String loadDrone(@PathVariable("droneId") Long droneId, @Valid @RequestBody Set<Medication> medications,
			Errors errors) {

		if (errors.hasErrors()) {
			return errors.toString();
		} else {
			return droneService.loadDrone(droneId, medications);
		}
	}

	@GetMapping("/{droneId}/content")
	public Set<Medication> getDroneMedication(@PathVariable("droneId") Long droneId) {
		return droneService.getLoadedMedication(droneId);
	}

	@GetMapping("/available")
	public List<Drone> getAvailableDrones() {
		return droneService.getAvailableDrones();
	}

	@GetMapping("/{droneId}/battery_level")
	public double checkDroneBatteryLevel(@PathVariable("droneId") Long droneId) {
		return droneService.checkDroneBatteryLevel(droneId);
	}

}
