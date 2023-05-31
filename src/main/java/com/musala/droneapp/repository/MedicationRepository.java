package com.musala.droneapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musala.droneapp.model.Medication;

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Long> {

}
