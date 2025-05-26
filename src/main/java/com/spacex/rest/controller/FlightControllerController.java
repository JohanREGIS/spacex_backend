package com.spacex.rest.controller;

import com.spacex.rest.entity.FlightController;
import com.spacex.rest.service.FlightControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Johan REGIS
 */

@RestController
@RequestMapping("/flight_controllers")
@CrossOrigin("*")
public class FlightControllerController {

    @Autowired
    private FlightControllerService flightControllerService;

    @PostMapping("/register")
    public ResponseEntity<FlightController> saveFlightController(@RequestBody FlightController flightController){
        FlightController savedFlightController = flightControllerService.saveFlightController(flightController);
        return ResponseEntity.ok(savedFlightController);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightController> getFlightControllerById(@PathVariable Long id){
        return flightControllerService.getFlightControllerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<FlightController>> getAllFlightControllers(){
        List<FlightController> flightControllers = flightControllerService.getAllFlightControllers();
        return ResponseEntity.ok(flightControllers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightControllerById(@PathVariable Long id){
        if(flightControllerService.getFlightControllerById(id).isPresent()){
            flightControllerService.deleteFlightControllerById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightController> updateFlightController(@PathVariable Long id, @RequestBody FlightController flightController){

        if(flightController == null) {
            return ResponseEntity.notFound().build();
        }

        FlightController flightControllerMAJ = flightControllerService.updateFlightController(id, flightController);
        return ResponseEntity.ok().body(flightControllerMAJ);
    }
}
