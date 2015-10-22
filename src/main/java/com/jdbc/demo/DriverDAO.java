package com.jdbc.demo;

import com.jdbc.demo.domain.Driver;

import java.util.List;

public interface DriverDAO {
    List<Driver> getAll();
    Driver add(Driver driver);
    Driver get(int id);
    Driver get(String firstName, String lastName);
    void update(Driver driver);
    void delete(Driver driver);
}
