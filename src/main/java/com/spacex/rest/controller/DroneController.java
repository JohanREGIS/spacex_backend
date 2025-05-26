package com.spacex.rest.controller;

import com.spacex.rest.entity.Drone;
import com.spacex.rest.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Johan REGIS
 */

@RestController
@RequestMapping("/drones")
@CrossOrigin("*")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @PostMapping("/register")
    public ResponseEntity<Drone> saveDrone(@RequestBody Drone drone){
        Drone savedDrone = droneService.saveDrone(drone);
        return ResponseEntity.ok(savedDrone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drone> getDroneById(@PathVariable Long id){
        return droneService.getDroneById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Drone>> getAllDrones(){
        List<Drone> drones = droneService.getAllDrones();
        return ResponseEntity.ok(drones);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDroneById(@PathVariable Long id){
        if(droneService.getDroneById(id).isPresent()){
            droneService.deleteDroneById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drone> updateDrone(@PathVariable Long id, @RequestBody Drone drone){

        if(drone == null) {
            return ResponseEntity.notFound().build();
        }

        Drone droneMAJ = droneService.updateDrone(id, drone);
        return ResponseEntity.ok().body(droneMAJ);
    }
}
