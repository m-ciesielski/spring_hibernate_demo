package com.jdbc.demo.services;

import com.jdbc.demo.domain.Address;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Mateusz on 03-Nov-15.
 */
public class AddressEntityManagerTest {

    private AddressEntityManager addressEntityManager = new AddressEntityManager();
    private ArrayList<Address> testAddresses = new ArrayList<Address>();

    @Before
    public void setUp() throws Exception {
        Address testAddress1 = new Address();
        testAddress1.setTown("Radom");
        testAddress1.setCode("54-543");
        testAddress1.setCountry("Polska");
        testAddress1.setHouseNumber("87/4");
        testAddress1.setStreet("Dolna");
        testAddresses.add(testAddress1);

        Address testAddress2 = new Address();
        testAddress2.setTown("Sosnowiec");
        testAddress2.setCode("11-700");
        testAddress2.setCountry("Polska");
        testAddress2.setHouseNumber("3/4");
        testAddress2.setStreet("Agrarna");
        testAddresses.add(testAddress2);
    }

    @After
    public void tearDown() throws Exception {
        for (Address testAddress: testAddresses){
            addressEntityManager.delete(testAddress.getId());
        }
    }

    @Test
    public void testGetAll() throws Exception {
        addressEntityManager.add(testAddresses.get(0));
        addressEntityManager.add(testAddresses.get(1));

        Assert.assertTrue(addressEntityManager.getAll().size()>=2);
        Assert.assertTrue(addressEntityManager.getAll().contains(testAddresses.get(0)));
        Assert.assertTrue(addressEntityManager.getAll().contains(testAddresses.get(1)));
    }

    @Test
    public void testAdd() throws Exception {
        addressEntityManager.add(testAddresses.get(0));

        Assert.assertTrue(addressEntityManager.getAll().contains(testAddresses.get(0)));
    }

    @Test
    public void testGet() throws Exception {
        Address address = addressEntityManager.add(testAddresses.get(0));

        Assert.assertEquals(address, addressEntityManager.get(address.getId()));
    }

    @Test
    public void testDelete() throws Exception {
        Address address = addressEntityManager.add(testAddresses.get(0));
        addressEntityManager.delete(address.getId());

        Assert.assertFalse(addressEntityManager.getAll().contains(address));
    }

    @Test
    public void testUpdate() throws Exception {
        Address address = addressEntityManager.add(testAddresses.get(0));
        address.setTown("Kielce");
        addressEntityManager.update(address);

        Assert.assertEquals(address, addressEntityManager.get(address.getId()));
    }
}