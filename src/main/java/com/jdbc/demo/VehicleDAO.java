package com.jdbc.demo;

import com.jdbc.demo.domain.Vehicle;

import java.util.List;

/**
 * Created by mciesielski on 2015-10-23.
 */
public interface VehicleDAO {
    List<Vehicle> getAll();
    Vehicle add(Vehicle vehicle);
    Vehicle get(int id);
    Vehicle get(String VIN);
    Vehicle update(Vehicle vehicle);
    void delete(Vehicle vehicle);
}
