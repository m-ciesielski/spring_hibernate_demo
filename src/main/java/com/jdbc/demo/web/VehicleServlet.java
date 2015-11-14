package com.jdbc.demo.web;

import com.jdbc.demo.domain.Vehicle;
import com.jdbc.demo.services.VehicleEntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

/**
 * Created by Mateusz on 14-Nov-15.
 */

@WebServlet(urlPatterns = "/vehicles")
public class VehicleServlet extends HttpServlet {

    private final static Logger LOGGER = LoggerFactory.getLogger(VehicleServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LOGGER.info(request.toString());

        response.setContentType("text/html");

        boolean delete = (request.getParameter("delete") != null);
        boolean update = (request.getParameter("id") != null);

        Vehicle vehicle = new Vehicle();

        try {

            VehicleEntityManager vehicleEntityManager = new VehicleEntityManager();

            if (delete) {
                int id = Integer.parseInt(request.getParameter("id").trim());
                LOGGER.info("Deleting vehicle:" + vehicleEntityManager.get(id));
                vehicleEntityManager.delete(id);
            }
            else{
                vehicle.setBrand(request.getParameter("brand"));
                vehicle.setEngine(Integer.parseInt(request.getParameter("engine").trim()));
                vehicle.setHorsepower(Integer.parseInt(request.getParameter("horsepower").trim()));
                vehicle.setType(request.getParameter("type"));
                vehicle.setVIN(request.getParameter("VIN"));
                vehicle.setProductionDate(new Date(System.currentTimeMillis()));
                vehicle.setAvailable(Boolean.parseBoolean(request.getParameter("available")));
                if (update){
                    vehicle.setId(Integer.parseInt(request.getParameter("id").trim()));
                    LOGGER.info("Updating vehicle:" + vehicle.toString());
                    vehicleEntityManager.update(vehicle);
                }else {
                    LOGGER.info("Adding vehicle:" + vehicle.toString());
                    vehicleEntityManager.add(vehicle);
                }
            }
        } catch (Exception e) {
            vehicle = null;

            if (delete)
                response.sendError(500, String.format("Internal Server Error: Deleting Vehicle failed. Exception: %s \n Cause: %s \n Stacktrace: %s", e.getMessage(),e.getCause(), Arrays.toString(e.getStackTrace())));
            else
                response.sendError(500, String.format("Internal Server Error: Adding Vehicle failed. Exception: %s \n Cause: %s \n Stacktrace: %s",e.getMessage(), e.getCause(), Arrays.toString(e.getStackTrace())));
            LOGGER.error(Arrays.toString(e.getStackTrace()));
        }

        response.setStatus(200);
        LOGGER.info(response.toString());

        //Redirect to vehicles.jsp
        request.getRequestDispatcher("/vehicles.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        boolean getAll = (request.getParameter("id") == null);

        try {
            VehicleEntityManager vehicleEntityManager = (VehicleEntityManager) getServletContext().getAttribute("vehicles");
            if (getAll) {
                for (Vehicle vehicle: vehicleEntityManager.getAll())
                    response.getWriter().write(vehicle.toString() + '\n');
            } else {
                int id = Integer.parseInt(request.getParameter("id"));
                Vehicle vehicle = vehicleEntityManager.get(id);
                response.getWriter().write(vehicle.toString());
            }

        } catch (Exception e) {
            if (!getAll)
                response.sendError(500, "Internal Server Error: Cannot get vehicle with id: " + request.getParameter("id") + "\n"
                        + Arrays.toString(e.getStackTrace()));
            else
                response.sendError(500, "Internal Server Error: Cannot get vehicles list\n"
                        + Arrays.toString(e.getStackTrace()));
            return;
        }

        response.setStatus(200);


    }
}
