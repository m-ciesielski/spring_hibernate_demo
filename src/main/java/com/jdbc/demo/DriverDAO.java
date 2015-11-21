package com.jdbc.demo;

import com.jdbc.demo.domain.Driver;
import com.jdbc.demo.domain.FreightTransport;

import java.util.List;

public interface DriverDAO {
    List<Driver> getAll();
    Driver add(Driver driver);
    Driver get(long id);
    void update(Driver driver);
    void delete(long id);
    void delete(Driver driver);
    List<FreightTransport> getTransports(int id, FreightTransportDAO freightTransportDAO);
}
