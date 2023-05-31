package com.musala.droneapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

@Entity
@Table(name = "medication")
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// @Pattern(regexp = "^[a-zA-Z\\d-_]$", message = "allowed only letters,
	// numbers, '-', '_'")
	private String name;
	private double weight;

	// @Pattern(regexp = "^[A-Z\\d_]$", message = "allowed only upper case letters,
	// underscore and numbers")
	private String code;
	private byte[] image;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "medications")
	@JsonIgnore
	Set<Drone> drone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Set<Drone> getDrone() {
		return drone;
	}

	public void setDrone(Set<Drone> drone) {
		this.drone = drone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Medication dt = (Medication) o;
		return false;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public String toString() {
		return "Medication [id=" + id + ", name=" + name + ", weight=" + weight + ", code=" + code + ", image="
				+ Arrays.toString(image) + "]";
	}

}
