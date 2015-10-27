package com.jdbc.demo;

import com.jdbc.demo.domain.Vehicle;
import com.jdbc.demo.services.VehicleEntityManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by mciesielski on 2015-10-23.
 */
public class VehicleEntityManagerTest {

    private VehicleEntityManager vehicleEntityManager;

    @Before
    public void setUp() throws Exception {
        vehicleEntityManager = new VehicleEntityManager();
    }

    @Test
    public void getAllTest() throws Exception {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setAvailable(true);
        vehicle1.setBrand("Scania");
        vehicle1.setCarReviewDate(new Date(System.currentTimeMillis()));
        vehicle1.setCarReviewExpirationDate(null);
        vehicle1.setEngine(16);
        vehicle1.setHorsepower(300);
        vehicle1.setType("ZX-83");
        vehicle1.setId(0);
        vehicle1.setVIN("36457476436");
        vehicle1.setProductionDate(null);
        vehicleEntityManager.add(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setAvailable(true);
        vehicle2.setBrand("Scania");
        vehicle2.setCarReviewDate(new Date(System.currentTimeMillis()));
        vehicle2.setCarReviewExpirationDate(null);
        vehicle2.setEngine(16);
        vehicle2.setHorsepower(300);
        vehicle2.setType("ZX-83");
        vehicle2.setId(1);
        vehicle2.setVIN("7859657586");
        vehicle2.setProductionDate(null);
        vehicleEntityManager.add(vehicle2);

        Assert.assertTrue(vehicleEntityManager.getAll().contains(vehicle1));
        Assert.assertTrue(vehicleEntityManager.getAll().contains(vehicle2));
        Assert.assertEquals(vehicleEntityManager.getAll().size(), 2);
    }

    @Test
    public void deleteTest() throws Exception {
        Vehicle vehicle1 = vehicleEntityManager.add(new Vehicle(1, "AABB", 16, new Date(System.currentTimeMillis()), "123121441", "FSfsdfs", 300,
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), true));
        Vehicle vehicle2 = vehicleEntityManager.add(new Vehicle(3, "dsadad", 16, new Date(System.currentTimeMillis()), "123121441", "FSfsdfs", 300,
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), false));
        vehicleEntityManager.delete(vehicle1);
        Assert.assertFalse(vehicleEntityManager.getAll().contains(vehicle1));
        Assert.assertTrue(vehicleEntityManager.getAll().contains(vehicle2));
        Assert.assertEquals(vehicleEntityManager.getAll().size(), 1);
    }

    @Test
    public void addTest() throws Exception {
        Vehicle vehicle1 = vehicleEntityManager.add(new Vehicle(1, "AABB", 16, new Date(System.currentTimeMillis()), "123121441", "FSfsdfs", 300,
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), true));
        Assert.assertTrue(vehicleEntityManager.getAll().contains(vehicle1));
    }

    @Test
    public void getByIdTest() throws Exception {
        Vehicle vehicle1 = vehicleEntityManager.add(new Vehicle(1, "AABB", 16, new Date(System.currentTimeMillis()), "123121441", "FSfsdfs", 300,
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), true));
        Vehicle foundVehicle1 = vehicleEntityManager.get(vehicle1.getId());
        Assert.assertEquals(vehicle1, foundVehicle1);
    }

    @Test
    public void getByVINTest() throws Exception {
        Vehicle vehicle1 = vehicleEntityManager.add(new Vehicle(1, "AABB", 16, new Date(System.currentTimeMillis()), "123121441", "FSfsdfs", 300,
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), true));
        Vehicle foundVehicle1 = vehicleEntityManager.get(vehicle1.getVIN());
        Assert.assertEquals(vehicle1, foundVehicle1);
    }
}