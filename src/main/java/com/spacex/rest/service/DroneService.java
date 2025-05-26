package com.spacex.rest.service;

import com.spacex.rest.entity.Drone;
import com.spacex.rest.repository.IDroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Johan REGIS
 */

@Service
public class DroneService {
    
    @Autowired
    private IDroneRepository droneRepository;

    public Drone saveDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public Optional<Drone> getDroneById(Long id) {
        return droneRepository.findById(id);
    }

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    public void deleteDroneById(Long id) {
        droneRepository.deleteById(id);
    }

    public Drone updateDrone(Long id, Drone droneUpdate) {
        Drone droneToUpdate = droneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drone introuvable"));

        droneToUpdate.setModele(droneUpdate.getModele());
        droneToUpdate.setPoids(droneUpdate.getPoids());
        droneToUpdate.setPorteeMax(droneUpdate.getPorteeMax());
        droneToUpdate.setCapaciteBatterie(droneUpdate.getCapaciteBatterie());
        droneToUpdate.setLongueur(droneUpdate.getLongueur());
        droneToUpdate.setLargeur(droneUpdate.getLargeur());
        droneToUpdate.setHauteur(droneUpdate.getHauteur());
        droneToUpdate.setCamera(droneUpdate.getCamera());

        return droneRepository.save(droneToUpdate);
    }
}
