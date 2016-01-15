package com.jdbc.demo.services;

import com.jdbc.demo.VehicleDAO;
import com.jdbc.demo.domain.Vehicle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import utils.TestModelsFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mciesielski on 2015-10-23.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class VehicleEntityManagerTest {

    @Autowired
    private VehicleDAO vehicleManager;

    private ArrayList<Vehicle> testVehicles = new ArrayList<Vehicle>();

    @Before
    public void setUp() throws Exception {
        testVehicles.add(TestModelsFactory.createTestVehicle1());
        testVehicles.add(TestModelsFactory.createTestVehicle2());
    }

    @After
    public void tearDown() throws Exception {
        for (Vehicle testVehicle: testVehicles){
            if(vehicleManager.get(testVehicle.getId()) != null)
            vehicleManager.delete(testVehicle);
        }

    }

    @Test
    public void getAllTest() throws Exception {
        Vehicle vehicle1 = vehicleManager.add(testVehicles.get(0));
        Vehicle vehicle2 = vehicleManager.add(testVehicles.get(1));

        Assert.assertTrue(vehicleManager.getAll().contains(vehicle1));
        Assert.assertTrue(vehicleManager.getAll().contains(vehicle2));
    }

    @Test
    public void deleteTest() throws Exception {

        List<Vehicle> vehiclesBeforeDeletion = vehicleManager.getAll();
        Vehicle vehicle1 = vehicleManager.add(testVehicles.get(0));
        Assert.assertTrue(vehicleManager.getAll().contains(vehicle1));
        vehicleManager.delete(testVehicles.get(0));

        Assert.assertFalse(vehicleManager.getAll().contains(vehicle1));
        Assert.assertTrue(vehicleManager.getAll().containsAll(vehiclesBeforeDeletion));
        Assert.assertEquals(vehiclesBeforeDeletion.size(), vehicleManager.getAll().size());
    }

    @Test
    public void addTest() throws Exception {
        List<Vehicle> vehiclesBeforeAddition = vehicleManager.getAll();
        Vehicle vehicle = vehicleManager.add(testVehicles.get(0));
        Assert.assertTrue(vehicleManager.getAll().contains(vehicle));
        Assert.assertTrue(vehicleManager.getAll().containsAll(vehiclesBeforeAddition));
        Assert.assertEquals(vehiclesBeforeAddition.size()+1, vehicleManager.getAll().size());
    }

    @Test
    public void getByIdTest() throws Exception {

        Vehicle vehicle = vehicleManager.add(testVehicles.get(0));
        Assert.assertTrue(vehicleManager.getAll().contains(vehicle));
        Vehicle foundVehicle = vehicleManager.get((int)vehicle.getId());
        Assert.assertEquals(vehicle, foundVehicle);
    }

    @Test
    public void testUpdate() throws Exception {

        List<Vehicle> vehiclesBeforeUpdate = vehicleManager.getAll();
        Vehicle vehicle1 = vehicleManager.add(testVehicles.get(0));

        Assert.assertTrue(vehicleManager.getAll().contains(vehicle1));

        vehicle1.setBrand("QWERTY");
        vehicleManager.update(vehicle1);
        Vehicle updatedVehicle1 = vehicleManager.get(vehicle1.getId());

        Assert.assertEquals(vehicle1, updatedVehicle1);
        Assert.assertTrue(vehicleManager.getAll().containsAll(vehiclesBeforeUpdate));

    }
}