package com.spacex.rest.service;

import com.spacex.rest.entity.GPSModule;
import com.spacex.rest.repository.IGPSModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Johan REGIS
 */

@Service
public class GPSModuleService {

    @Autowired
    private IGPSModuleRepository gPSModuleRepository;

    public GPSModule saveGPSModule(GPSModule gpsModule) {
        return gPSModuleRepository.save(gpsModule);
    }

    public Optional<GPSModule> getGPSModuleById(Long id) {
        return gPSModuleRepository.findById(id);
    }

    public List<GPSModule> getAllGPSModules() {
        return gPSModuleRepository.findAll();
    }

    public void deleteGPSModuleById(Long id) {
        gPSModuleRepository.deleteById(id);
    }

    public GPSModule updateGPSModule(Long id, GPSModule gpsModuleUpdate) {
        GPSModule gpsModuleToUpdate = gPSModuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GPSModule introuvable"));

        gpsModuleToUpdate.setModele(gpsModuleUpdate.getModele());
        gpsModuleToUpdate.setPoids(gpsModuleUpdate.getPoids());
        gpsModuleToUpdate.setPorteeMax(gpsModuleUpdate.getPorteeMax());
        gpsModuleToUpdate.setCapaciteBatterie(gpsModuleUpdate.getCapaciteBatterie());
        gpsModuleToUpdate.setLongueur(gpsModuleUpdate.getLongueur());
        gpsModuleToUpdate.setLargeur(gpsModuleUpdate.getLargeur());
        gpsModuleToUpdate.setHauteur(gpsModuleUpdate.getHauteur());
        gpsModuleToUpdate.setCamera(gpsModuleUpdate.getCamera());
        gpsModuleToUpdate.setLatitude(gpsModuleUpdate.getLatitude());
        gpsModuleToUpdate.setLongitude(gpsModuleUpdate.getLongitude());
        gpsModuleToUpdate.setAltitude(gpsModuleUpdate.getAltitude());
        gpsModuleToUpdate.setFlightController(gpsModuleUpdate.getFlightController());

        return gPSModuleRepository.save(gpsModuleToUpdate);
    }
}
