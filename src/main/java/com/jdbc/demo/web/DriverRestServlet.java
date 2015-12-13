package com.jdbc.demo.web;

import com.jdbc.demo.DriverDAO;
import com.jdbc.demo.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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

    @GET
    @Path("{id}")
    @Produces("text/plain")
    public String getDriver(@PathParam("id")long id){
        return driverManager.get(id).toString();
    }
}
