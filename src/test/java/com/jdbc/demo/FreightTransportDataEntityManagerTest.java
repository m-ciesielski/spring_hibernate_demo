package com.jdbc.demo;

import com.jdbc.demo.domain.*;
import com.jdbc.demo.services.FreightTransportDataEntityManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mateusz on 23-Oct-15.
 */
public class FreightTransportDataEntityManagerTest{

    private FreightTransportDataEntityManager freightTransportDataEntityManager;

    @Before
    public void setUp() throws Exception {
        freightTransportDataEntityManager = new FreightTransportDataEntityManager();
    }

    @Test
    public void addTest() throws Exception {
        FreightTransport freightTransport = new FreightTransport();
        Driver driver = new Driver();
        Vehicle vehicle = new Vehicle();
        Trailer trailer = new Trailer();

        FreightTransportData freightTransportData = new FreightTransportData();
        freightTransportData.setDriver(driver);
        freightTransportData.setVehicle(vehicle);
        freightTransportData.setTrailer(trailer);
        freightTransportData.setFreightTransport(freightTransport);
        freightTransportDataEntityManager.add(freightTransportData);

        Assert.assertTrue(freightTransportDataEntityManager.getAll().contains(freightTransportData));
    }
}