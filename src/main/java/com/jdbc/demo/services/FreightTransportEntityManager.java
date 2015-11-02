package com.jdbc.demo.services;

import com.jdbc.demo.FreightTransportDAO;
import com.jdbc.demo.domain.*;
import com.jdbc.demo.domain.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 23-Oct-15.
 */
public class FreightTransportEntityManager extends EntityManager implements FreightTransportDAO {

    public ClientEntityManager clientEntityManager;
    public DriverEntityManager driverEntityManager;
    public VehicleEntityManager vehicleEntityManager;
    public AddressEntityManager addressEntityManager;

    private PreparedStatement updateStatement;
    private PreparedStatement createStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement getStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getDriversStatement;
    private PreparedStatement getVehiclesStatement;

    public FreightTransportEntityManager() {

        try {

            clientEntityManager = new ClientEntityManager();
            driverEntityManager = new DriverEntityManager();
            vehicleEntityManager = new VehicleEntityManager();
            addressEntityManager = new AddressEntityManager();

            Connection connection = DriverManager.getConnection(connectionString);
            ResultSet rs = connection.getMetaData().getTables(null, null, null,
                    null);
            boolean tableExists = false;

            while (rs.next()) {
                if ("FreightTransport".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }

            if (!tableExists)
                throw new SQLException("Table FreightTransport not found in database");

            createStatement = connection.prepareStatement("INSERT INTO FreightTransport(id_load_Address, id_unload_Address, id_Client," +
                    " distance, load_date, unload_date, finished) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            deleteStatement = connection.prepareStatement("Delete FROM FreightTransport WHERE id_FreightTransport = ?");
            getAllStatement = connection.prepareStatement("SELECT * FROM FreightTransport");
            getStatement = connection.prepareStatement("SELECT * FROM FreightTransport WHERE id_FreightTransport = ?");
            getDriversStatement = connection.prepareStatement("SELECT id_Driver FROM FreightTransportDrivers WHERE id_FreightTransport = ?");
            getVehiclesStatement = connection.prepareStatement("SELECT id_Vehicle FROM FreightTransportVehicles WHERE id_FreightTransport = ?");
            updateStatement = connection.prepareStatement("UPDATE FreightTransport SET id_load_Address = ?, id_unload_Address = ?," +
                    " id_Client = ? distance = ?, load_date = ?, unload_date = ?, finished = ? WHERE id_FreightTransport = ?");
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public ArrayList<FreightTransport> getAll() {
        ArrayList<FreightTransport> freightTransports = new ArrayList<FreightTransport>();

        try {
            ResultSet rs = getAllStatement.executeQuery();

            while (rs.next()) {
                FreightTransport freightTransport = new FreightTransport();
                freightTransport.setId(rs.getInt("id_FreightTransport"));
                freightTransport.setClient(clientEntityManager.get(rs.getInt("id_Client")));
                freightTransport.setLoadAddress(addressEntityManager.get(rs.getInt("id_load_Address")));
                freightTransport.setUnloadAddress(addressEntityManager.get(rs.getInt("id_load_Address")));
                freightTransport.setDistance(rs.getInt("distance"));
                freightTransport.setValue(rs.getBigDecimal("value"));
                freightTransport.setLoadDate(rs.getDate("load_date"));
                freightTransport.setUnloadDate(rs.getDate("unload_date"));
                freightTransport.setFinished(rs.getBoolean("finished"));

                freightTransports.add(freightTransport);
            }
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return freightTransports;
    }

    public FreightTransport add(FreightTransport freightTransport) {

        try {

            createStatement.setInt(1, freightTransport.getLoadAddress().getId());
            createStatement.setInt(2, freightTransport.getUnloadAddress().getId());
            createStatement.setInt(3, freightTransport.getClient().getId());
            createStatement.setInt(4, freightTransport.getDistance());
            createStatement.setDate(5, freightTransport.getLoadDate());
            createStatement.setDate(6, freightTransport.getUnloadDate());
            createStatement.setBoolean(7, freightTransport.getFinished());

            createStatement.executeUpdate();

            ResultSet generatedKeys = createStatement.getGeneratedKeys();
            generatedKeys.next();

            freightTransport.setId(generatedKeys.getInt(1));

        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }

        return freightTransport;
    }

    public void update(FreightTransport freightTransport) {
        try {

            updateStatement.setInt(1, freightTransport.getLoadAddress().getId());
            updateStatement.setInt(2, freightTransport.getUnloadAddress().getId());
            updateStatement.setInt(3, freightTransport.getClient().getId());
            updateStatement.setInt(4, freightTransport.getDistance());
            updateStatement.setDate(5, freightTransport.getLoadDate());
            updateStatement.setDate(6, freightTransport.getUnloadDate());
            updateStatement.setBoolean(7, freightTransport.getFinished());

            updateStatement.setInt(8, freightTransport.getId());

            updateStatement.executeUpdate();

            ResultSet generatedKeys = updateStatement.getGeneratedKeys();
            generatedKeys.next();

            freightTransport.setId(generatedKeys.getInt(1));

        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

    }

    public void delete(int id) {
        try {
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FreightTransport get(int id) {

        FreightTransport freightTransport = new FreightTransport();

        try {
            getStatement.setInt(1, id);
            ResultSet rs = getStatement.executeQuery();
            rs.next();

            freightTransport.setId(rs.getInt("id_FreightTransport"));
            freightTransport.setClient(clientEntityManager.get(rs.getInt("id_Client")));
            freightTransport.setLoadAddress(addressEntityManager.get(rs.getInt("id_load_Address")));
            freightTransport.setUnloadAddress(addressEntityManager.get(rs.getInt("id_load_Address")));
            freightTransport.setDistance(rs.getInt("distance"));
            freightTransport.setValue(rs.getBigDecimal("value"));
            freightTransport.setLoadDate(rs.getDate("load_date"));
            freightTransport.setUnloadDate(rs.getDate("unload_date"));
            freightTransport.setFinished(rs.getBoolean("finished"));

        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            freightTransport = null;
        }

        return freightTransport;
    }

    public List<Driver> getDrivers(int id) {

        ArrayList<Driver> drivers = new ArrayList<Driver>();

        try{
            getDriversStatement.setInt(1, id);
            ResultSet rs = getDriversStatement.executeQuery();

            while(rs.next()){
                drivers.add(driverEntityManager.get(rs.getInt("id_Driver")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            drivers = null;
        }

        return drivers;
    }

    public List<Vehicle> getVehicles(int id) {

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        try{
            getVehiclesStatement.setInt(1, id);
            ResultSet rs = getVehiclesStatement.executeQuery();

            while(rs.next()){
                vehicles.add(vehicleEntityManager.get(rs.getInt("id_Vehicle")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            vehicles = null;
        }

        return vehicles;
    }
}
