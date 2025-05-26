package com.spacex.rest.repository;

import com.spacex.rest.entity.GPSModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Johan REGIS
 */

@Repository
public interface IGPSModuleRepository extends JpaRepository<GPSModule, Long> {
}
