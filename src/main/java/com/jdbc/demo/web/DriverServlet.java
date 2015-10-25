package com.jdbc.demo.web;

import com.jdbc.demo.domain.Driver;
import com.jdbc.demo.services.DriverEntityManager;

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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try {
            Driver driver = new Driver();
            int id = Integer.parseInt(request.getParameter("id"));
            driver.setId(id);
            driver.setFirstName(request.getParameter("first-name"));
            driver.setLastName(request.getParameter("last-name"));

            DriverEntityManager driverEntityManager = (DriverEntityManager) getServletContext().getAttribute("driverEM");
            driverEntityManager.add(driver);
        } catch (Exception e) {
            response.sendError(500, "Internal Server Error: Adding Driver failed.\n" + Arrays.toString(e.getStackTrace()));
            return;
        }

        response.setStatus(200);

        //Redirect to drivers.jsp
        request.getRequestDispatcher("/drivers.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try {
            DriverEntityManager driverEntityManager = (DriverEntityManager) getServletContext().getAttribute("driverEM");
            int id = Integer.parseInt(request.getParameter("id"));
            Driver driver = driverEntityManager.get(id);
            response.getWriter().write(driver.toString());
        } catch (Exception e) {
            response.sendError(500, "Internal Server Error: Cannot get driver with id: " + request.getParameter("id") + "\n"
                    + Arrays.toString(e.getStackTrace()));
            return;
        }

        response.setStatus(200);


    }
}
