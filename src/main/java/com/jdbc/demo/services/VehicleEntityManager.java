package com.jdbc.demo.services;

import com.jdbc.demo.VehicleDAO;
import com.jdbc.demo.domain.Driver;
import com.jdbc.demo.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mciesielski on 2015-10-23.
 */
public class VehicleEntityManager extends EntityManager implements VehicleDAO{

    private ArrayList<Vehicle> vehicles;

    public VehicleEntityManager(){
        vehicles = new ArrayList<Vehicle>();
    }

    public List<Vehicle> getAll(){
        return vehicles;
    }

    public Vehicle update(Vehicle vehicle){
        //TODO
        return vehicle;
    }

    public Vehicle get(int id){
        for(Vehicle vehicle: vehicles) {
            if (vehicle.getId() == id)
                return vehicle;
        }
        return null;
    }

    public Vehicle get(String VIN){
        for(Vehicle vehicle: vehicles) {
            if (vehicle.getVIN().equals(VIN))
                return vehicle;
        }
        return null;
    }

    public Vehicle add(Vehicle vehicle){
        vehicles.add(vehicle);
        if (vehicles.contains(vehicle))
            return vehicle;
        else
            return null;
    }

    public void delete(Vehicle vehicle){
        vehicles.remove(vehicle);
    }
}
