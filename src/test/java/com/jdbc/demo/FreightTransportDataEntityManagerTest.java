package com.jdbc.demo;

import com.jdbc.demo.domain.*;
import com.jdbc.demo.services.FreightTransportDataEntityManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

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
        FreightTransport freightTransport = new FreightTransport(1, null, 3, 4, 454, new BigDecimal(434), new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), false, "");
        Driver driver = new Driver("dsaad", "dsada", "1124323", new BigDecimal(3000), null, true, false );
        Vehicle vehicle = new Vehicle("sdsad", 16, new Date(System.currentTimeMillis()), "dsadsa", "Scania", 320,
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), true);
        Trailer trailer = new Trailer("Wielton", "HG-54324", 4500, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()), true);

        FreightTransportData freightTransportData = freightTransportDataEntityManager.add(new FreightTransportData(freightTransport,
                driver, vehicle, trailer, new BigDecimal(1200), 125, 167, "" ));

        Assert.assertTrue(freightTransportDataEntityManager.getAll().contains(freightTransportData));
        Assert.assertEquals(freightTransportDataEntityManager.getAll().size(), 1);
    }
}