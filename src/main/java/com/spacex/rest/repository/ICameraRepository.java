package com.spacex.rest.repository;

import com.spacex.rest.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Johan REGIS
 */

@Repository
public interface ICameraRepository extends JpaRepository<Camera, Long> {
}
