package com.spacex.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Johan REGIS
 */

@Data
@Entity
@Table(name="FLIGHT_CONTROLLER")
public class FlightController {

	/* Attributs membres */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FLIGHT_CONTROLLER")
    private Long idFlightController;
    @Column(nullable = false)
    private double vitesse;
    @Column(nullable = false)
    private int altitudeCible;
    @Column(nullable = false)
    private int latitudeCible;
    @Column(nullable = false)
    private int longitudeCible;

    @OneToMany(mappedBy = "flightController")
    @JsonIgnoreProperties({"modele","poids","porteeMax","capaciteBatterie","longueur",
            "largeur","hauteur","camera","latitude","longitude","altitude","flightController"})
    private List<GPSModule> gpsModules;

	/* Constructeurs */
	/* Getters & Setters */
	
	/* Méthodes */
	
}
