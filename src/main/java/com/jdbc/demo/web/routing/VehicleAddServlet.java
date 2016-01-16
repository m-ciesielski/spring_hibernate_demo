package com.jdbc.demo.web.routing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateusz on 16-Jan-16.
 */
@WebServlet(urlPatterns = "vehicles/add")
public class VehicleAddServlet extends HttpServlet {

    private final static Logger LOGGER = LoggerFactory.getLogger(VehicleAddServlet.class);

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        LOGGER.info(String.format("Intercepted request %s. Redirecting to add_vehicle.jsp page.",
                httpServletRequest.getServletPath()));
        //Redirect to add_vehicle.jsp
        httpServletRequest.getRequestDispatcher("/add_vehicle.jsp").forward(httpServletRequest, httpServletResponse);

    }
}
