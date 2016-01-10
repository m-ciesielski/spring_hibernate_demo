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
 * Created by Mateusz on 10-Jan-16.
 */

@WebServlet(urlPatterns = "drivers/edit/*")
public class DriverEditServlet extends HttpServlet {

    private final static Logger LOGGER = LoggerFactory.getLogger(DriverEditServlet.class);

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        LOGGER.info(String.format("Intercepted request %s. Redirecting to edit_driver.jsp page.",
                httpServletRequest.getServletPath()));
        //Redirect to edit_drivers.jsp
        httpServletRequest.getRequestDispatcher("/edit_driver.jsp").forward(httpServletRequest, httpServletResponse);

    }
}
