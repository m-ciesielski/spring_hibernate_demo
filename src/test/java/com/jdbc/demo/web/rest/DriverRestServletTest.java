package com.jdbc.demo.web.rest;

import com.jayway.restassured.response.Response;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;

/**
 * Created by Mateusz on 02-Jan-16.
 */
public class DriverRestServletTest {

    @Test
    public void getDrivers(){
        Response resp = get("localhost:8080/api/");
    }
}
