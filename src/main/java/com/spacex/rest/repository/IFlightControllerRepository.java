package com.spacex.rest.repository;

import com.spacex.rest.entity.FlightController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Johan REGIS
 */

@Repository
public interface IFlightControllerRepository extends JpaRepository<FlightController, Long> {
}
