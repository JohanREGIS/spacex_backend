package com.spacex.rest.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Johan REGIS
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="GPS_MODULE")
public class GPSModule extends Drone {
	
	/* Attributs membres */
	@Column(nullable = false)
	private int latitude; // En mètres
	@Column(nullable = false)
	private int longitude; // En mètres
	@Column(nullable = false)
	private int altitude; // En mètres

	@ManyToOne
	@JoinColumn(name = "flight_controller_id", nullable = false)
	private FlightController flightController;
	
	/* Constructeurs */
	/* Getters & Setters */
	
	/* Méthodes */

}
