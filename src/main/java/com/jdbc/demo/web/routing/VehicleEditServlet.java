package com.jdbc.demo.web.routing;

import com.jdbc.demo.VehicleDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateusz on 16-Jan-16.
 */
@WebServlet(urlPatterns = "vehicles/edit/*")
public class VehicleEditServlet extends HttpServlet {

    private final static Logger LOGGER = LoggerFactory.getLogger(VehicleEditServlet.class);

    @EJB
    VehicleDAO vehicleManager;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        LOGGER.info(String.format("Intercepted request %s.",
                httpServletRequest.getServletPath()));

        long id = Long.valueOf(httpServletRequest.getPathInfo().replace("/", ""));

        if(vehicleManager.get(id) == null){
            LOGGER.info(String.format("Driver with id %d not found.", id));
            httpServletResponse.sendError(404, String.format("Vehicle with id %d not found.", id));
            return;
        }

        LOGGER.info("Redirecting to edit_vehicle.jsp page.");
        httpServletRequest.getRequestDispatcher("/edit_vehicle.jsp").forward(httpServletRequest, httpServletResponse);

    }
}
