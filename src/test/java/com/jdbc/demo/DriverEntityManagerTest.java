package com.jdbc.demo;

import com.jdbc.demo.domain.Address;
import com.jdbc.demo.domain.Driver;
import com.jdbc.demo.services.AddressEntityManager;
import com.jdbc.demo.services.DriverEntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Mateusz on 22-Oct-15.
 */


public class DriverEntityManagerTest {

    private DriverEntityManager driverEntityManager = new DriverEntityManager();
    private AddressEntityManager addressEntityManager = new AddressEntityManager();
    private ArrayList<Driver> testDrivers = new ArrayList<Driver>();
    private ArrayList<Address> testAddresses = new ArrayList<Address>();


    @Before
    public void setUp() throws Exception {

        Address testAddress1 = new Address();
        testAddress1.setTown("Gniezno");
        testAddress1.setCode("56-763");
        testAddress1.setCountry("Polska");
        testAddress1.setHouseNumber("66");
        testAddress1.setStreet("Krzywa");
        addressEntityManager.add(testAddress1);
        testAddresses.add(testAddress1);
    }

    @After
    public void tearDown() throws Exception {
        for (Driver testDriver: testDrivers){
            driverEntityManager.delete(testDriver);
        }
        for (Address testAddress: testAddresses){
            addressEntityManager.delete(testAddress);
        }

    }

    @Test
    public void addTest  () throws Exception {
        Driver driver = new Driver();
        driver.setAddress(testAddresses.get(0));
        driver.setFirstName("Jerzy");
        driver.setLastName("Banan");
        driver.setAvailable(true);
        driver.setDeleted(false);
        driver.setPESEL("75100345678");
        driverEntityManager.add(driver);
        testDrivers.add(driver);

        Assert.assertTrue(driverEntityManager.getAll().contains(driver));
    }

    @Test
    public void getAllTest  () throws Exception {

        Driver driver1 = new Driver();
        driver1.setAddress(testAddresses.get(0));
        driver1.setFirstName("Jerzy");
        driver1.setLastName("Banan");
        driver1.setPESEL("12345678910");
        driver1.setAvailable(true);
        driver1.setDeleted(false);

        driverEntityManager.add(driver1);
        testDrivers.add(driver1);

        Driver driver2 = new Driver();
        driver2.setAddress(testAddresses.get(0));
        driver2.setFirstName("Tadeusz");
        driver2.setLastName("Czapla");
        driver2.setSalary(new BigDecimal(3200).setScale(2, BigDecimal.ROUND_CEILING));
        driver2.setPESEL("12345678911");
        driver2.setAvailable(true);
        driver2.setDeleted(false);

        driverEntityManager.add(driver2);
        testDrivers.add(driver2);

        ArrayList<Driver> all = driverEntityManager.getAll();

        Assert.assertTrue(driverEntityManager.getAll().contains(driver1));
        Assert.assertTrue(driverEntityManager.getAll().contains(driver2));
    }

    @Test
    public void deleteTest  () throws Exception {
        Driver driver1 = new Driver();
        driver1.setAddress(testAddresses.get(0));
        driver1.setFirstName("Jerzy");
        driver1.setLastName("Banan");
        driver1.setPESEL("84020506011");
        driver1.setAvailable(true);
        driver1.setDeleted(false);
        testDrivers.add(driver1);

        driverEntityManager.add(driver1);
        driverEntityManager.delete(driver1);
        Assert.assertFalse(driverEntityManager.getAll().contains(driver1));
    }

    @Test
    public void getByIdTest  () throws Exception {
        Driver driver1 = new Driver();
        driver1.setAddress(testAddresses.get(0));
        driver1.setFirstName("Jerzy");
        driver1.setLastName("Banan");
        driver1.setAvailable(true);
        driver1.setPESEL("84030506011");
        driver1.setDeleted(false);
        driverEntityManager.add(driver1);
        testDrivers.add(driver1);

        Driver foundDriver1 = driverEntityManager.get(driver1.getId());
        Assert.assertEquals(driver1, foundDriver1);
    }

}
