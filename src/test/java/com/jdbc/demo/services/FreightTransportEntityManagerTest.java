package com.jdbc.demo.services;

import com.jdbc.demo.domain.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Mateusz on 03-Nov-15.
 */
public class FreightTransportEntityManagerTest {

    private FreightTransportEntityManager freightTransportEntityManager = new FreightTransportEntityManager();

    private AddressEntityManager addressEntityManager = new AddressEntityManager();
    private ClientEntityManager clientEntityManager = new ClientEntityManager();
    private VehicleEntityManager vehicleEntityManager = new VehicleEntityManager();
    private DriverEntityManager driverEntityManager = new DriverEntityManager();

    private ArrayList<FreightTransport> testFreightTransports = new ArrayList<FreightTransport>();

    private ArrayList<Address> testAddresses = new ArrayList<Address>();
    private ArrayList<Client> testClients = new ArrayList<Client>();
    private ArrayList<Vehicle> testVehicles = new ArrayList<Vehicle>();
    private ArrayList<Driver> testDrivers = new ArrayList<Driver>();

    @Before
    public void setUp() throws Exception {
        Address testAddress1 = new Address();
        testAddress1.setTown("Radom");
        testAddress1.setCode("54-543");
        testAddress1.setCountry("Polska");
        testAddress1.setHouseNumber("87/4");
        testAddress1.setStreet("Dolna");
        addressEntityManager.add(testAddress1);
        testAddresses.add(testAddress1);

        Address testAddress2 = new Address();
        testAddress2.setTown("Sosnowiec");
        testAddress2.setCode("11-700");
        testAddress2.setCountry("Polska");
        testAddress2.setHouseNumber("3/4");
        testAddress2.setStreet("Agrarna");
        addressEntityManager.add(testAddress2);
        testAddresses.add(testAddress2);

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

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setBrand("Scania");
        vehicle1.setEngine(16);
        vehicle1.setHorsepower(300);
        vehicle1.setType("ZX-83");
        vehicle1.setVIN("1M8GDM9A_KP042777");
        vehicle1.setProductionDate(new Date(System.currentTimeMillis()));
        vehicleEntityManager.add(vehicle1);
        testVehicles.add(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setBrand("Scania");
        vehicle2.setEngine(16);
        vehicle2.setHorsepower(300);
        vehicle2.setType("ZX-83");
        vehicle2.setVIN("1M8GDM9A_KE042777");
        vehicle2.setProductionDate(new Date(System.currentTimeMillis()));
        vehicleEntityManager.add(vehicle2);
        testVehicles.add(vehicle2);

        Client client1 = new Client();
        client1.setName("ABC SA");
        client1.setAddress(testAddresses.get(0));
        client1.setNIP("1234567890");
        client1.setBankAccountNumber("14532534634632");
        clientEntityManager.add(client1);
        testClients.add(client1);

        Client client2 = new Client();
        client2.setName("XYZ sp. z. o o.");
        client2.setAddress(testAddresses.get(1));
        client2.setNIP("1234567490");
        client2.setBankAccountNumber("145325312334632");
        clientEntityManager.add(client2);
        testClients.add(client2);

        FreightTransport freightTransport1 = new FreightTransport();
        freightTransport1.setFinished(false);
        freightTransport1.setValue(new BigDecimal(45000).setScale(2, BigDecimal.ROUND_CEILING));
        freightTransport1.setDistance(1450);
        freightTransport1.setUnloadAddress(testAddress1);
        freightTransport1.setClient(client1);
        freightTransport1.setLoadAddress(testAddress2);
        freightTransport1.setDrivers(testDrivers);
        freightTransport1.setVehicles(testVehicles);
        testFreightTransports.add(freightTransport1);

        FreightTransport freightTransport2 = new FreightTransport();
        freightTransport2.setFinished(false);
        freightTransport2.setValue(new BigDecimal(32657).setScale(2, BigDecimal.ROUND_CEILING));
        freightTransport2.setDistance(1234);
        freightTransport2.setUnloadAddress(testAddress2);
        freightTransport2.setClient(client2);
        freightTransport2.setLoadAddress(testAddress1);
        freightTransport2.setDrivers(testDrivers);
        freightTransport2.setVehicles(testVehicles);
        testFreightTransports.add(freightTransport2);
    }

    @After
    public void tearDown() throws Exception {
        for (FreightTransport freightTransport: testFreightTransports){
            freightTransportEntityManager.delete(freightTransport.getId());
        }
        for (Client testClient : testClients) {
            clientEntityManager.delete(testClient.getId());
        }
        for (Vehicle testVehicle: testVehicles){
            vehicleEntityManager.delete(testVehicle);
        }
        for (Driver testDriver: testDrivers){
            driverEntityManager.delete(testDriver.getId());
        }
        for (Address testAddress : testAddresses) {
            addressEntityManager.delete(testAddress.getId());
        }
    }

    @Test
    public void testGetAll() throws Exception {
        FreightTransport freightTransport1 = freightTransportEntityManager.add(testFreightTransports.get(0));
        FreightTransport freightTransport2 = freightTransportEntityManager.add(testFreightTransports.get(1));

        Assert.assertTrue(freightTransportEntityManager.getAll().size()>=2);
        Assert.assertTrue(freightTransportEntityManager.getAll().contains(freightTransport1));
        Assert.assertTrue(freightTransportEntityManager.getAll().contains(freightTransport2));
    }

    @Test
    public void testAdd() throws Exception {
        FreightTransport freightTransport1 = freightTransportEntityManager.add(testFreightTransports.get(0));

        Assert.assertTrue(freightTransportEntityManager.getAll().contains(freightTransport1));
    }

    @Test
    public void testUpdate() throws Exception {
        FreightTransport freightTransport1 = freightTransportEntityManager.add(testFreightTransports.get(0));
        freightTransport1.setDistance(1789);
        freightTransportEntityManager.update(freightTransport1);

        FreightTransport updatedFreightTransport1 = freightTransportEntityManager.get(freightTransport1.getId());

        Assert.assertEquals(freightTransport1, updatedFreightTransport1);
    }

    @Test
    public void testDelete() throws Exception {
        FreightTransport freightTransport1 = freightTransportEntityManager.add(testFreightTransports.get(0));

        Assert.assertTrue(freightTransportEntityManager.getAll().contains(freightTransport1));

        freightTransportEntityManager.delete(freightTransport1.getId());

        Assert.assertFalse(freightTransportEntityManager.getAll().contains(freightTransport1));
    }

    @Test
    public void testGet() throws Exception {
        FreightTransport freightTransport1 = freightTransportEntityManager.add(testFreightTransports.get(0));
        FreightTransport foundFreightTransport1 = freightTransportEntityManager.get(freightTransport1.getId());

        Assert.assertEquals(freightTransport1, foundFreightTransport1);
    }

    @Test
    public void testGetDrivers() throws Exception {
        FreightTransport freightTransport1 = freightTransportEntityManager.add(testFreightTransports.get(0));

        Assert.assertEquals(freightTransport1.getDrivers(),
                freightTransportEntityManager.getDrivers(freightTransport1.getId()));
    }

    @Test
    public void testGetVehicles() throws Exception {
        FreightTransport freightTransport1 = freightTransportEntityManager.add(testFreightTransports.get(0));

        Assert.assertEquals(freightTransport1.getVehicles(),
                freightTransportEntityManager.getVehicles(freightTransport1.getId()));
    }
}