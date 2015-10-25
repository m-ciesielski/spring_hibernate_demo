package com.jdbc.demo;

import com.jdbc.demo.domain.*;

import java.util.List;

/**
 * Created by Mateusz on 23-Oct-15.
 */
public interface FreighTransportDataDAO {
    List<FreightTransportData> getAll();
    FreightTransportData add(FreightTransportData freightTransportData);
    //FreightTransportData get(long id);
    FreightTransportData get(FreightTransport freightTransport, Driver driver);
    FreightTransportData get(FreightTransport freightTransport, Vehicle vehicle);
    void delete(FreightTransportData freightTransportData);
    void update(FreightTransportData freightTransportData);
    List<FreightTransportData> getAllDriverTransports(Driver driver);
    List<FreightTransportData> getAllVehicleTransports(Vehicle vehicle);
    List<FreightTransportData> getAllTrailerTransports(Trailer trailer);

}
