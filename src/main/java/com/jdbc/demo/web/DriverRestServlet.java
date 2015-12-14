package com.jdbc.demo.web;

import com.jdbc.demo.DriverDAO;
import com.jdbc.demo.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;

/**
 * Created by Mateusz on 07-Dec-15.
 */

@Path("/api/drivers")
public class DriverRestServlet {

    @Autowired
    DriverDAO driverManager;

    @GET
    @Produces("text/plain")
    public String getDrivers(){
        StringBuilder str = new StringBuilder();
        for (Driver driver : driverManager.getAll()){
            str.append(String.format("%s\n", driver.toString()));
        }
        return str.toString();
    }


    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Driver addDriver(Driver driver){
        return driverManager.add(driver);
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Driver getDriver(@PathParam("id")long id){
        return driverManager.get(id);
    }

    @POST
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Driver updateDriver(Driver driver){
        return driverManager.update(driver);
    }

    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    public void deleteDriver(Driver driver){
        driverManager.delete(driver);
    }
}
