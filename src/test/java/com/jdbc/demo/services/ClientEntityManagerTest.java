package com.jdbc.demo.services;

import com.jdbc.demo.domain.Address;
import com.jdbc.demo.domain.Client;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Mateusz on 02-Nov-15.
 */
public class ClientEntityManagerTest {

    private ClientEntityManager clientEntityManager = new ClientEntityManager();
    private AddressEntityManager addressEntityManager = new AddressEntityManager();
    private ArrayList<Client> testClients = new ArrayList<Client>();
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
        for (Client testClient : testClients) {
            clientEntityManager.delete(testClient.getId());
        }
        for (Address testAddress : testAddresses) {
            addressEntityManager.delete(testAddress);
        }
    }

    @Test
    public void testGetAll() throws Exception {

        Client client1 = new Client();
        client1.setName("ABC SA");
        client1.setAddress(testAddresses.get(0));
        client1.setNIP("1234567890");
        client1.setBankAccountNumber("14532534634632");
        clientEntityManager.add(client1);
        testClients.add(client1);

        Client client2 = new Client();
        client2.setName("XYZ sp. z. o o.");
        client2.setAddress(testAddresses.get(0));
        client2.setNIP("1234567490");
        client2.setBankAccountNumber("145325312334632");
        clientEntityManager.add(client2);
        testClients.add(client2);

        Assert.assertTrue(clientEntityManager.getAll().contains(client1));
        Assert.assertTrue(clientEntityManager.getAll().contains(client2));

    }

    @Test
    public void testAdd() throws Exception {
        Client client1 = new Client();
        client1.setName("ABC SA");
        client1.setAddress(testAddresses.get(0));
        client1.setNIP("1234567890");
        client1.setBankAccountNumber("14532534634632");
        clientEntityManager.add(client1);
        testClients.add(client1);

        ArrayList<Client> all = (ArrayList<Client>) clientEntityManager.getAll();


        Assert.assertTrue(clientEntityManager.getAll().contains(client1));
    }

    @Test
    public void testGetById() throws Exception {
        Client client1 = new Client();
        client1.setName("ABC SA");
        client1.setAddress(testAddresses.get(0));
        client1.setNIP("1234567890");
        client1.setBankAccountNumber("14532534634632");
        clientEntityManager.add(client1);
        testClients.add(client1);

        Client foundClient1 = clientEntityManager.get(client1.getId());

        Assert.assertEquals(foundClient1, client1);
    }

    @Test
    public void testGetByName() throws Exception {
        Client client1 = new Client();
        client1.setName("ABC SA");
        client1.setAddress(testAddresses.get(0));
        client1.setNIP("1234567890");
        client1.setBankAccountNumber("14532534634632");
        clientEntityManager.add(client1);
        testClients.add(client1);

        Client foundClient1 = clientEntityManager.get(client1.getName());

        Assert.assertEquals(foundClient1, client1);
    }

    @Test
    public void testUpdate() throws Exception {
        Client client1 = new Client();
        client1.setName("ABC SA");
        client1.setAddress(testAddresses.get(0));
        client1.setNIP("1234567890");
        client1.setBankAccountNumber("14532534634632");
        clientEntityManager.add(client1);
        testClients.add(client1);

        client1.setName("DEF SA");
        clientEntityManager.update(client1);

        Client updatedClient = clientEntityManager.get(client1.getId());

        Assert.assertEquals(client1, updatedClient);
    }

    @Test
    public void testDelete() throws Exception {
        Client client1 = new Client();
        client1.setName("ABC SA");
        client1.setAddress(testAddresses.get(0));
        client1.setNIP("1234567890");
        client1.setBankAccountNumber("14532534634632");
        clientEntityManager.add(client1);
        testClients.add(client1);

        Assert.assertTrue(clientEntityManager.getAll().contains(client1));

        clientEntityManager.delete(client1.getId());

        Assert.assertFalse(clientEntityManager.getAll().contains(client1));
    }
}