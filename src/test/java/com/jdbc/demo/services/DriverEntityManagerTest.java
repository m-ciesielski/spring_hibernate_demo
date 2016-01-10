package com.jdbc.demo.services;

import com.jdbc.demo.AddressDAO;
import com.jdbc.demo.DriverDAO;
import com.jdbc.demo.domain.Address;
import com.jdbc.demo.domain.Driver;
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
 * Created by Mateusz on 22-Oct-15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class DriverEntityManagerTest {

    @Autowired
    private DriverDAO driverManager;

    @Autowired
    private AddressDAO addressManager;
    
    private ArrayList<Driver> testDrivers = new ArrayList<Driver>();
    private ArrayList<Address> testAddresses = new ArrayList<Address>();

    @Before
    public void setUp() throws Exception {

        testAddresses.add(addressManager.add(TestModelsFactory.createTestAddress1()));
        testDrivers.add(TestModelsFactory.createTestDriver1(testAddresses.get(0)));
        testDrivers.add(TestModelsFactory.createTestDriver2(testAddresses.get(0)));
    }

    @After
    public void tearDown() throws Exception {
        for(Driver driver : testDrivers){
            if(driverManager.get(driver.getId()) != null)
                driverManager.delete(driver);
        }
        for(Address address : testAddresses){
            if(addressManager.get(address.getId()) != null)
                addressManager.delete(address);
        }
    }

    @Test
    public void addTest  () throws Exception {
        List<Driver> driversBeforeAddition = driverManager.getAll();
        Driver driver = driverManager.add(testDrivers.get(0));
        List<Driver> drivers = driverManager.getAll();
        Assert.assertTrue(drivers.contains(driver));
        Assert.assertTrue(drivers.containsAll(driversBeforeAddition));
    }

    @Test
    public void getAllTest  () throws Exception {
        Driver driver1 = driverManager.add(testDrivers.get(0));
        Driver driver2 = driverManager.add(testDrivers.get(1));
        List<Driver> drivers = driverManager.getAll();
        Assert.assertTrue(drivers.contains(driver1));
        Assert.assertTrue(drivers.contains(driver2));
    }

    @Test
    public void deleteTest  () throws Exception {
        List<Driver> driversBeforeDelete = driverManager.getAll();
        Driver driver1 = driverManager.add(testDrivers.get(0));
        Assert.assertTrue(driverManager.getAll().contains(driver1));
        driverManager.delete(driver1.getId());

        List<Driver> drivers = driverManager.getAll();
        Assert.assertFalse(drivers.contains(driver1));
        Assert.assertTrue(drivers.containsAll(driversBeforeDelete));
    }

    @Test
    public void getByIdTest  () throws Exception {
        Driver driver1 = driverManager.add(testDrivers.get(0));

        Driver foundDriver1 = driverManager.get(driver1.getId());
        Assert.assertEquals(driver1, foundDriver1);
    }

    @Test
    public void testUpdate() throws Exception {

        List<Driver> driversBeforeUpdate = driverManager.getAll();
        Driver driver1 = driverManager.add(testDrivers.get(0));
        Assert.assertTrue(driverManager.getAll().contains(driver1));

        driver1.setFirstName("Stefan");
        driverManager.update(driver1);

        Driver updatedDriver = driverManager.get(driver1.getId());

        Assert.assertEquals(driver1, updatedDriver);
        Assert.assertTrue(driverManager.getAll().containsAll(driversBeforeUpdate));

    }
}
