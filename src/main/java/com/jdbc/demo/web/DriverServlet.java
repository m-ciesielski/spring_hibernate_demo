package com.jdbc.demo.web;

import com.jdbc.demo.domain.Driver;
import com.jdbc.demo.services.DriverEntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

//Just a prototype implementation...

@WebServlet(urlPatterns = "/driver")
public class DriverServlet extends HttpServlet {

    private final static Logger LOGGER = LoggerFactory.getLogger(DriverServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LOGGER.info(request.toString());

        response.setContentType("text/html");

        boolean delete = true;
        if (request.getParameter("delete") == null)
            delete = false;

        try {

            DriverEntityManager driverEntityManager = new DriverEntityManager();
            //AddressEntityManager addressEntityManager = (AddressEntityManager) getServletContext().getAttribute("addresses");


            if (delete) {
                int id = Integer.parseInt(request.getParameter("id").trim());
                LOGGER.info("Deleting driver:" + driverEntityManager.get(id));
                driverEntityManager.delete(id);
            } else {
                Driver driver = new Driver();
                driver.setFirstName(request.getParameter("first-name"));
                driver.setLastName(request.getParameter("last-name"));
                driver.setPESEL(request.getParameter("pesel"));
                driver.setAddress(driverEntityManager.addressEntityManager.get(Integer.parseInt(request.getParameter("address-id").trim())));
                LOGGER.info("Adding driver:" + driver.toString());
                driverEntityManager.add(driver);
            }

        } catch (Exception e) {
            if (delete)
                response.sendError(500, String.format("Internal Server Error: Deleting Driver failed. Exception: %s \n Cause: %s \n Stacktrace: %s", e.getMessage(),e.getCause(), Arrays.toString(e.getStackTrace())));
            else
                response.sendError(500, String.format("Internal Server Error: Adding Driver  failed. Exception: %s \n Cause: %s \n Stacktrace: %s",e.getMessage(), e.getCause(), Arrays.toString(e.getStackTrace())));
            LOGGER.error(Arrays.toString(e.getStackTrace()));
        }

        response.setStatus(200);
        LOGGER.info(response.toString());

        //Redirect to drivers.jsp
        request.getRequestDispatcher("/drivers.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        boolean getAll = false;
        if (request.getParameter("id") == null)
            getAll = true;

        try {
            DriverEntityManager driverEntityManager = (DriverEntityManager) getServletContext().getAttribute("drivers");
            if (getAll) {
                for (Driver driver : driverEntityManager.getAll())
                    response.getWriter().write(driver.toString() + '\n');
            } else {
                int id = Integer.parseInt(request.getParameter("id"));
                Driver driver = driverEntityManager.get(id);
                response.getWriter().write(driver.toString());
            }

        } catch (Exception e) {
            if (!getAll)
                response.sendError(500, "Internal Server Error: Cannot get driver with id: " + request.getParameter("id") + "\n"
                        + Arrays.toString(e.getStackTrace()));
            else
                response.sendError(500, "Internal Server Error: Cannot get drivers list\n"
                        + Arrays.toString(e.getStackTrace()));
            return;
        }

        response.setStatus(200);


    }

}
