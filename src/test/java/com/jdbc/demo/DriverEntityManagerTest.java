package com.jdbc.demo;

import com.jdbc.demo.domain.Driver;
import com.jdbc.demo.services.DriverEntityManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Mateusz on 22-Oct-15.
 */


public class DriverEntityManagerTest {

    private DriverEntityManager driverEntityManager;

    @Before
    public void setUp(){
        driverEntityManager = new DriverEntityManager();
    }
    @Test
    public void addTest  () throws Exception {
        Driver driver = driverEntityManager.add(new Driver("Jerzy", "Banan", "86200407043", new BigDecimal(3000), new BigDecimal(0), Boolean.TRUE, Boolean.FALSE));
        Assert.assertTrue(driverEntityManager.getAll().contains(driver));
    }

    @Test
    public void getAllTest  () throws Exception {
        Driver driver1 = driverEntityManager.add(new Driver("Jerzy", "Banan", "86200407043", new BigDecimal(3000), new BigDecimal(0), Boolean.TRUE, Boolean.FALSE));
        Driver driver2 = driverEntityManager.add(new Driver("Tadeusz", "Czapla", "'Czapla', 'Tadeusz'", new BigDecimal(3000), new BigDecimal(0), Boolean.TRUE, Boolean.FALSE));
        Assert.assertEquals(driverEntityManager.getAll().size() , 2);
        Assert.assertTrue(driverEntityManager.getAll().contains(driver1));
        Assert.assertTrue(driverEntityManager.getAll().contains(driver2));
    }

    @Test
    public void deleteTest  () throws Exception {
        Driver driver1 = driverEntityManager.add(new Driver("Jerzy", "Banan", "86200407043", new BigDecimal(3000), new BigDecimal(0), Boolean.TRUE, Boolean.FALSE));
        Driver driver2 = driverEntityManager.add(new Driver("Tadeusz", "Czapla", "'Czapla', 'Tadeusz'", new BigDecimal(3000), new BigDecimal(0), Boolean.TRUE, Boolean.FALSE));
        driverEntityManager.delete(driver1);
        Assert.assertEquals(driverEntityManager.getAll().size() , 1);
        Assert.assertFalse(driverEntityManager.getAll().contains(driver1));
        Assert.assertTrue(driverEntityManager.getAll().contains(driver2));
    }

    @Test
    public void getByIdTest  () throws Exception {
        Driver driver1 = driverEntityManager.add(new Driver("Jerzy", "Banan", "86200407043", new BigDecimal(3000), new BigDecimal(0), Boolean.TRUE, Boolean.FALSE));
        driverEntityManager.add(new Driver("Tadeusz", "Czapla", "'Czapla', 'Tadeusz'", new BigDecimal(3000), new BigDecimal(0), Boolean.TRUE, Boolean.FALSE));
        Driver foundDriver1 = driverEntityManager.get(driver1.getId());
        Assert.assertEquals(driver1, foundDriver1);
    }

    @Test
    public void getByNameTest  () throws Exception {
        Driver driver1 = driverEntityManager.add(new Driver("Jerzy", "Banan", "86200407043", new BigDecimal(3000), new BigDecimal(0), Boolean.TRUE, Boolean.FALSE));
        driverEntityManager.add(new Driver("Tadeusz", "Czapla", "'Czapla', 'Tadeusz'", new BigDecimal(3000), new BigDecimal(0), Boolean.TRUE, Boolean.FALSE));
        Driver foundDriver1 = driverEntityManager.get("Jerzy", "Banan");
        Assert.assertEquals(driver1, foundDriver1);
    }
}
