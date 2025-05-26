package com.spacex.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Johan REGIS
 */

@Data
@Entity
@Table(name="DRONE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Drone {
	
	/* Attributs membres */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DRONE")
	protected Long idDrone;
	@Column(nullable = false)
	protected String modele;
	@Column(nullable = false)
	protected double poids; // En grammes
	@Column(nullable = false)
	protected double porteeMax; // En mètres
	@Column(nullable = false)
	protected int capaciteBatterie; // En minutes
	@Column
	protected int longueur;
	protected int largeur;
	protected int hauteur;

	@ManyToOne
	@JoinColumn(name = "camera_id")
	@JsonIgnoreProperties({"resolution","zoom","drones"})
	private Camera camera;
	
	/* Constructeurs */
	/* Getters & Setters */
	
	/* Méthodes */
	
}
