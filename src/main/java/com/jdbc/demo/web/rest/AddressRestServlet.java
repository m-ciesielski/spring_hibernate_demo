package com.jdbc.demo.web.rest;

import com.jdbc.demo.AddressDAO;
import com.jdbc.demo.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Mateusz on 09-Jan-16.
 */

@Path("addresses")
@Stateless
public class AddressRestServlet {
    private final static Logger LOGGER = LoggerFactory.getLogger(AddressRestServlet.class);

    @EJB
    private AddressDAO addressManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Address> getAddresss() {
        return addressManager.getAll();
    }

    @POST
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    public Address addAddress(Address address) {

        LOGGER.info(String.format("Adding address %s.", address));
        return addressManager.add(address);
    }

    @Path("/{id}")
    @GET
    @Produces("application/json; charset=UTF-8")
    public Address getAddress(@PathParam("id") int id) {
        return addressManager.get(id);
    }

    @Path("/{id}")
    @POST
    @Consumes("application/json; charset=UTF-8")
    public void updateAddress(Address address) {
        LOGGER.info(String.format("Updating address %s.", address));
        addressManager.update(address);
    }

    @Path("/{id}")
    @DELETE
    public void deleteAddress(@PathParam("id") int id) {

        Address address = addressManager.get(id);
        LOGGER.info(String.format("Deleting address %s.", address));
        addressManager.delete(id);
    }
}
