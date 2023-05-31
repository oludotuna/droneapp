package com.musala.droneapp.schedules;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.musala.droneapp.model.Drone;
import com.musala.droneapp.repository.DroneRepository;

@Configuration
@EnableAsync
@EnableScheduling
public class BatteryLevels {

	private static final Logger logger = LoggerFactory.getLogger(BatteryLevels.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	@Autowired
	private DroneRepository droneRepository;

	@Scheduled(fixedRate = 1000)
	public void checkBatteryLevels() {
		
		logger.info("The time is now {}", dateFormat.format(new Date()));
		logger.info("Checking Drone Battery Level.....");
	        Iterable<Drone> drones = droneRepository.findAll();

	        drones.forEach((drone) -> {
	        	logger.info("Drone ID: "+drone.getId() +" currently has a "+drone.getBatteryCapacity()+"% battery capacity.");
	        });

	        logger.info("============End of Cycle==========");
	}
}