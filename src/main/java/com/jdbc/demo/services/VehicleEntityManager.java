package com.jdbc.demo.services;

import com.jdbc.demo.VehicleDAO;
import com.jdbc.demo.domain.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mciesielski on 2015-10-23.
 */
public class VehicleEntityManager extends EntityManager implements VehicleDAO {

    private PreparedStatement updateStatement;
    private PreparedStatement createStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement clearStatement;
    private PreparedStatement getStatement;
    private PreparedStatement getAllStatement;

    public VehicleEntityManager() {
        try {

            Connection connection = DriverManager.getConnection(connectionString);
            ResultSet rs = connection.getMetaData().getTables(null, null, null,
                    null);
            boolean tableExists = false;

            while (rs.next()) {
                if ("Vehicle".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }

            if (!tableExists)
                throw new SQLException("Table Vehicle not found in database");

            createStatement = connection.prepareStatement("INSERT INTO Vehicle(brand, model, mileage," +
                    " engine, production_date, VIN, horsepower) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            deleteStatement = connection.prepareStatement("Delete FROM Vehicle WHERE id_Vehicle = ?");
            clearStatement = connection.prepareStatement("Delete FROM Vehicle");
            getAllStatement = connection.prepareStatement("SELECT * FROM Vehicle");
            getStatement = connection.prepareStatement("SELECT * FROM Vehicle WHERE id_Vehicle = ?");
            updateStatement = connection.prepareStatement("UPDATE Vehicle SET brand = ?, model = ?," +
                    " mileage = ? engine = ?, production_date = ?, VIN = ?, horsepower = ? WHERE id_Vehicle = ?");
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public List<Vehicle> getAll() {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        try {
            ResultSet rs = getAllStatement.executeQuery();

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id_Vehicle"));
                vehicle.setBrand(rs.getString("brand"));
                vehicle.setType(rs.getString("model"));
                vehicle.setMileage(rs.getInt("mileage"));
                vehicle.setEngine(rs.getInt("engine"));
                vehicle.setProductionDate(rs.getDate("production_date"));
                vehicle.setVIN(rs.getString("VIN"));
                vehicle.setHorsepower(rs.getInt("horsepower"));

                vehicles.add(vehicle);
            }
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return vehicles;
    }

    public void update(Vehicle vehicle) {
        try{
            updateStatement.setString(1, vehicle.getBrand());
            updateStatement.setString(2, vehicle.getType());
            updateStatement.setInt(3, vehicle.getMileage());
            updateStatement.setInt(4, vehicle.getEngine());
            updateStatement.setDate(5, vehicle.getProductionDate());
            updateStatement.setString(6, vehicle.getVIN());
            updateStatement.setInt(7, vehicle.getHorsepower());

            updateStatement.setInt(8, vehicle.getId());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Vehicle get(int id) {

        Vehicle vehicle = new Vehicle();

        try {
            getStatement.setInt(1, id);
            ResultSet rs = getStatement.executeQuery();

            rs.next();
            vehicle.setId(rs.getInt("id_Vehicle"));
            vehicle.setBrand(rs.getString("brand"));
            vehicle.setType(rs.getString("model"));
            vehicle.setMileage(rs.getInt("mileage"));
            vehicle.setEngine(rs.getInt("engine"));
            vehicle.setProductionDate(rs.getDate("production_date"));
            vehicle.setVIN(rs.getString("VIN"));
            vehicle.setHorsepower(rs.getInt("horsepower"));

        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return vehicle;
    }

    public Vehicle add(Vehicle vehicle) {
        try {

            createStatement.setString(1, vehicle.getBrand());
            createStatement.setString(2, vehicle.getType());
            createStatement.setInt(3, vehicle.getMileage());
            createStatement.setInt(4, vehicle.getEngine());
            createStatement.setDate(5, vehicle.getProductionDate());
            createStatement.setString(6, vehicle.getVIN());
            createStatement.setInt(7, vehicle.getHorsepower());

            createStatement.executeUpdate();

            ResultSet generatedKeys = createStatement.getGeneratedKeys();
            generatedKeys.next();

            vehicle.setId(generatedKeys.getInt(1));

        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }

        return vehicle;
    }

    public void delete(Vehicle vehicle) {
        try {
            deleteStatement.setInt(1, vehicle.getId());
            deleteStatement.executeUpdate();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }
}
