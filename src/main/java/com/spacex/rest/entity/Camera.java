package com.spacex.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Johan REGIS
 */

@Data
@Entity
@Table(name="CAMERA")
public class Camera {
	
	/* Attributs membres */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CAMERA")
	private Long idCamera;
	@Column(nullable = false)
	private String resolution;
	@Column(nullable = false)
	private int zoom;

	@OneToMany(mappedBy = "camera")
	@JsonIgnore
	private List<Drone> drones;

	/* Constructeurs */
	/* Getters & Setters */
	
	/* Méthodes */
	
}
