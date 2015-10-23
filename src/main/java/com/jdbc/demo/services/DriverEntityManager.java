package com.jdbc.demo.services;

import com.jdbc.demo.DriverDAO;
import com.jdbc.demo.domain.Driver;

import java.util.ArrayList;

/**
 * Created by Mateusz on 22-Oct-15.
 */
public class DriverEntityManager extends EntityManager implements DriverDAO {

    public ArrayList<Driver> drivers;

    public DriverEntityManager(){
        drivers = new ArrayList<Driver>();
    }

    public ArrayList<Driver> getAll(){
        return drivers;
    }

    public Driver add(Driver driver){
        drivers.add(driver);
        if (drivers.contains(driver))
            return driver;
        else
            return null;
    }

    public Driver get(String firstName, String lastName) {
        for(Driver driver: drivers) {
            if (driver.getFirstName().equals(firstName) && driver.getLastName().equals(lastName))
                return driver;
        }
        return null;
    }

    public Driver get(int id) {
        for(Driver driver: drivers) {
            if (driver.getId() == id)
                return driver;
        }
        return null;
    }

    public void delete(Driver driver) {
        drivers.remove(driver);
    }

    public void update(Driver driver){
        //TODO
    }

    public void clear() {
        drivers.clear();
    }
}
