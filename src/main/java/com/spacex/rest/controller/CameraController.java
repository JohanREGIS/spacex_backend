package com.spacex.rest.controller;

import com.spacex.rest.entity.Camera;
import com.spacex.rest.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Johan REGIS
 */

@RestController
@RequestMapping("/cameras")
@CrossOrigin("*")
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @PostMapping("/register")
    public ResponseEntity<Camera> saveCamera(@RequestBody Camera camera){
        Camera savedCamera = cameraService.saveCamera(camera);
        return ResponseEntity.ok(savedCamera);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camera> getCameraById(@PathVariable Long id){
        return cameraService.getCameraById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Camera>> getAllCameras(){
        List<Camera> cameras = cameraService.getAllCameras();
        return ResponseEntity.ok(cameras);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCameraById(@PathVariable Long id){
        if(cameraService.getCameraById(id).isPresent()){
            cameraService.deleteCameraById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camera> updateCamera(@PathVariable Long id, @RequestBody Camera camera){

        if(camera == null) {
            return ResponseEntity.notFound().build();
        }

        Camera cameraMAJ = cameraService.updateCamera(id, camera);
        return ResponseEntity.ok().body(cameraMAJ);
    }
}
