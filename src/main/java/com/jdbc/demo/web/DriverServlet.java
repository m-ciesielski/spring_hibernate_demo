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

        boolean delete = false;
        if (request.getParameter("delete") != null && request.getParameter("delete").equals("true"))
            delete=true;

        try {

            int id = Integer.parseInt(request.getParameter("id"));
            DriverEntityManager driverEntityManager = (DriverEntityManager) getServletContext().getAttribute("driverEM");

            if (delete){
                driverEntityManager.delete(id);
            }
            else{
                Driver driver = new Driver();
                driver.setId(id);
                driver.setFirstName(request.getParameter("first-name"));
                driver.setLastName(request.getParameter("last-name"));
                driverEntityManager.add(driver);
            }

        } catch (Exception e) {
            if(delete)
                response.sendError(500, "Internal Server Error: Adding Driver failed.\n" + Arrays.toString(e.getStackTrace()));
            else
                response.sendError(500, "Internal Server Error: Cannot get driver with id: " + request.getParameter("id") + "\n"
                        + Arrays.toString(e.getStackTrace()));
            return;
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
            DriverEntityManager driverEntityManager = (DriverEntityManager) getServletContext().getAttribute("driverEM");
            if(getAll){
                for(Driver driver: driverEntityManager.getAll())
                    response.getWriter().write(driver.toString()+'\n');
            }
            else{
                int id = Integer.parseInt(request.getParameter("id"));
                Driver driver = driverEntityManager.get(id);
                response.getWriter().write(driver.toString());
            }

        } catch (Exception e) {
            response.sendError(500, "Internal Server Error: Cannot get driver with id: " + request.getParameter("id") + "\n"
                    + Arrays.toString(e.getStackTrace()));
            return;
        }

        response.setStatus(200);


    }

}
