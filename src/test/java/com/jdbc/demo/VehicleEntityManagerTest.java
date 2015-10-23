package com.jdbc.demo;

import com.jdbc.demo.domain.Vehicle;
import com.jdbc.demo.services.VehicleEntityManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

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
        Vehicle vehicle1 = vehicleEntityManager.add(new Vehicle(1, "AABB", 16, new Date(System.currentTimeMillis()), "123121441", "FSfsdfs", 300,
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), true));
        Vehicle vehicle2 = vehicleEntityManager.add(new Vehicle(3, "dsadad", 16, new Date(System.currentTimeMillis()), "123121441", "FSfsdfs", 300,
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), false));
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