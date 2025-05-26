package com.spacex.rest.repository;

import com.spacex.rest.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Johan REGIS
 */

@Repository
public interface IDroneRepository extends JpaRepository<Drone, Long> {
}
