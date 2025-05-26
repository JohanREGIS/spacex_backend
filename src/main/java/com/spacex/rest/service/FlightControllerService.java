package com.spacex.rest.service;

import com.spacex.rest.entity.FlightController;
import com.spacex.rest.repository.IFlightControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Johan REGIS
 */

@Service
public class FlightControllerService {

    @Autowired
    private IFlightControllerRepository flightControllerRepository;

    public FlightController saveFlightController(FlightController flightController) {
        return flightControllerRepository.save(flightController);
    }

    public Optional<FlightController> getFlightControllerById(Long id) {
        return flightControllerRepository.findById(id);
    }

    public List<FlightController> getAllFlightControllers() {
        return flightControllerRepository.findAll();
    }

    public void deleteFlightControllerById(Long id) {
        flightControllerRepository.deleteById(id);
    }

    public FlightController updateFlightController(Long id, FlightController flightControllerUpdate) {
        FlightController flightControllerToUpdate = flightControllerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FlightController introuvable"));

        flightControllerToUpdate.setVitesse(flightControllerUpdate.getVitesse());
        flightControllerToUpdate.setAltitudeCible(flightControllerUpdate.getAltitudeCible());
        flightControllerToUpdate.setLatitudeCible(flightControllerUpdate.getLatitudeCible());
        flightControllerToUpdate.setLongitudeCible(flightControllerUpdate.getLongitudeCible());
        flightControllerToUpdate.setGpsModules(flightControllerUpdate.getGpsModules());

        return flightControllerRepository.save(flightControllerToUpdate);
    }
}
