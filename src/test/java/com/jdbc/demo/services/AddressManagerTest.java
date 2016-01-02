package com.jdbc.demo.services;

import com.jdbc.demo.AddressDAO;
import com.jdbc.demo.domain.Address;
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
 * Created by Mateusz on 03-Nov-15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class AddressManagerTest {

    @Autowired
    private AddressDAO addressManager;
    
    private ArrayList<Address> testAddresses = new ArrayList<Address>();

    @Before
    public void setUp() throws Exception {
        testAddresses.add(TestModelsFactory.createTestAddress1());
        testAddresses.add(TestModelsFactory.createTestAddress2());
    }

    @Test
    public void testGetAll() throws Exception {
        addressManager.add(testAddresses.get(0));
        addressManager.add(testAddresses.get(1));

        List<Address> addresses = addressManager.getAll();
        Assert.assertTrue(addresses.size()>=2);
        Assert.assertTrue(addresses.contains(testAddresses.get(0)));
        Assert.assertTrue(addresses.contains(testAddresses.get(1)));
    }

    @Test
    public void testAdd() throws Exception {
        List<Address> addressesBeforeAddition = addressManager.getAll();
        addressManager.add(testAddresses.get(0));
        List<Address> addresses = addressManager.getAll();
        Assert.assertTrue(addresses.contains(testAddresses.get(0)));
        Assert.assertTrue(addresses.containsAll(addressesBeforeAddition));
    }

    @Test
    public void testGet() throws Exception {
        Address address = addressManager.add(testAddresses.get(0));

        Assert.assertEquals(address, addressManager.get(address.getId()));
    }

    @Test
    public void testDelete() throws Exception {
        List<Address> addressesBeforeDelete = addressManager.getAll();
        Address address = addressManager.add(testAddresses.get(0));
        Assert.assertTrue(addressManager.getAll().contains(address));
        addressManager.delete(address.getId());

        List<Address> addresses = addressManager.getAll();
        Assert.assertFalse(addresses.contains(address));
        Assert.assertTrue(addresses.containsAll(addressesBeforeDelete));
    }

    @Test
    public void testUpdate() throws Exception {
        List<Address> addressedBeforeUpdate = addressManager.getAll();
        Address address = addressManager.add(testAddresses.get(0));
        address.setTown("Kielce");
        addressManager.update(address);
        Assert.assertEquals(address, addressManager.get(address.getId()));
        Assert.assertTrue(addressManager.getAll().containsAll(addressedBeforeUpdate));
    }
}