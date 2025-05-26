package com.spacex.rest.service;

import com.spacex.rest.entity.Camera;
import com.spacex.rest.repository.ICameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Johan REGIS
 */

@Service
public class CameraService {

    @Autowired
    private ICameraRepository cameraRepository;

    public Camera saveCamera(Camera camera) {
        return cameraRepository.save(camera);
    }

    public Optional<Camera> getCameraById(Long id) {
        return cameraRepository.findById(id);
    }

    public List<Camera> getAllCameras() {
        return cameraRepository.findAll();
    }

    public void deleteCameraById(Long id) {
        cameraRepository.deleteById(id);
    }

    public Camera updateCamera(Long id, Camera cameraUpdate) {
        Camera cameraToUpdate = cameraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Camera introuvable"));

        cameraToUpdate.setResolution(cameraUpdate.getResolution());
        cameraToUpdate.setZoom(cameraUpdate.getZoom());
        cameraToUpdate.setDrones(cameraUpdate.getDrones());

        return cameraRepository.save(cameraToUpdate);
    }
}
