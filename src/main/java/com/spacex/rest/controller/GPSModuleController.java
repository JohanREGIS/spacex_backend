package com.spacex.rest.controller;

import com.spacex.rest.entity.GPSModule;
import com.spacex.rest.service.GPSModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Johan REGIS
 */

@RestController
@RequestMapping("/gps_modules")
@CrossOrigin("*")
public class GPSModuleController {

    @Autowired
    private GPSModuleService gpsModuleService;

    @PostMapping("/register")
    public ResponseEntity<GPSModule> saveGPSModule(@RequestBody GPSModule gpsModule){
        GPSModule savedGPSModule = gpsModuleService.saveGPSModule(gpsModule);
        return ResponseEntity.ok(savedGPSModule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GPSModule> getGPSModuleById(@PathVariable Long id){
        return gpsModuleService.getGPSModuleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<GPSModule>> getAllGPSModules(){
        List<GPSModule> gpsModules = gpsModuleService.getAllGPSModules();
        return ResponseEntity.ok(gpsModules);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGPSModuleById(@PathVariable Long id){
        if(gpsModuleService.getGPSModuleById(id).isPresent()){
            gpsModuleService.deleteGPSModuleById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GPSModule> updateGPSModule(@PathVariable Long id, @RequestBody GPSModule gpsModule){

        if(gpsModule == null) {
            return ResponseEntity.notFound().build();
        }

        GPSModule gPSModuleMAJ = gpsModuleService.updateGPSModule(id, gpsModule);
        return ResponseEntity.ok().body(gPSModuleMAJ);
    }
}
