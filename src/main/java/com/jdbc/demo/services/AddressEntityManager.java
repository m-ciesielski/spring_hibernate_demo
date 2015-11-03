package com.jdbc.demo.services;

import com.jdbc.demo.AddressDAO;
import com.jdbc.demo.domain.Address;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Mateusz on 31-Oct-15.
 */
public class AddressEntityManager extends EntityManager implements AddressDAO {

    private PreparedStatement updateStatement;
    private PreparedStatement createStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement clearStatement;
    private PreparedStatement getStatement;
    private PreparedStatement getAllStatement;

    public AddressEntityManager() {

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            ResultSet rs = connection.getMetaData().getTables(null, null, null,
                    null);
            boolean tableExists = false;

            while (rs.next()) {
                if ("Address".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }

            if (!tableExists)
                throw new SQLException("Table Address not found in database");

            createStatement = connection.prepareStatement("INSERT INTO Address(house_number, street," +
                    " code, town,  country) VALUES (?,?,?, ?,?)", Statement.RETURN_GENERATED_KEYS);
            deleteStatement = connection.prepareStatement("Delete FROM Address WHERE id_Address = ?");
            clearStatement = connection.prepareStatement("Delete FROM Address");
            getAllStatement = connection.prepareStatement("SELECT * FROM Address");
            getStatement = connection.prepareStatement("SELECT * FROM Address WHERE id_Address = ?");
            updateStatement = connection.prepareStatement("UPDATE Address SET house_number = ?," +
                    " street = ?, town = ?, code = ?, country = ? WHERE id_Address = ?");
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public ArrayList<Address> getAll() {
        ArrayList<Address> addresses = new ArrayList<Address>();

        try {
            ResultSet rs = getAllStatement.executeQuery();

            while (rs.next()) {
                Address address = new Address();
                address.setId(rs.getInt("id_Address"));
                address.setCode(rs.getString("code"));
                address.setTown(rs.getString("town"));
                address.setCountry(rs.getString("country"));
                address.setHouseNumber(rs.getString("house_number"));
                address.setStreet(rs.getString("street"));

                addresses.add(address);
            }
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            addresses = null;
        }

        return addresses;
    }

    public Address add(Address address) {
        try {
            createStatement.setString(1, address.getHouseNumber());
            createStatement.setString(2, address.getStreet());
            createStatement.setString(3, address.getCode());
            createStatement.setString(4, address.getTown());
            createStatement.setString(5, address.getCountry());

            createStatement.executeUpdate();

            ResultSet generatedKeys = createStatement.getGeneratedKeys();
            generatedKeys.next();

            address.setId(generatedKeys.getInt(1));

        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }

        return address;
    }

    public Address get(int id) {

        Address address = new Address();

        try {
            getStatement.setInt(1, id);
            ResultSet rs = getStatement.executeQuery();
            rs.next();
            address.setId(rs.getInt("id_Address"));
            address.setStreet(rs.getString("street"));
            address.setHouseNumber(rs.getString("house_number"));
            address.setCountry(rs.getString("country"));
            address.setCode(rs.getString("code"));
            address.setTown(rs.getString("town"));
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            address = null;
        }

        return address;
    }

    public void delete(int id) {

        try {
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public void update(Address address) {
        try {
            updateStatement.setString(1, address.getHouseNumber());
            updateStatement.setString(2, address.getStreet());
            updateStatement.setString(3, address.getTown());
            updateStatement.setString(4, address.getCode());
            updateStatement.setString(5, address.getCountry());


            updateStatement.setInt(6, address.getId());
            updateStatement.executeUpdate();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public void clear() {
        try {
            clearStatement.executeUpdate();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }
}
