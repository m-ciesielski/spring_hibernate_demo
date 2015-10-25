package com.jdbc.demo.services;

import com.jdbc.demo.FreighTransportDataDAO;
import com.jdbc.demo.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 23-Oct-15.
 */
public class FreightTransportDataEntityManager implements FreighTransportDataDAO {

    private ArrayList<FreightTransportData> freightTransportDatas;

    public FreightTransportDataEntityManager() {
        this.freightTransportDatas = new ArrayList<FreightTransportData>();
    }

    public List<FreightTransportData> getAll() {
        return freightTransportDatas;
    }

    public FreightTransportData add(FreightTransportData freightTransportData) {
        freightTransportDatas.add(freightTransportData);
        if(freightTransportDatas.contains(freightTransportData))
            return freightTransportData;
        return null;
    }

    public FreightTransportData get(FreightTransport freightTransport, Driver driver) {
        for(FreightTransportData freightTransportData: freightTransportDatas){
            if(freightTransportData.getDriver().equals(driver))
                return freightTransportData;
        }
        return null;
    }

    public FreightTransportData get(FreightTransport freightTransport, Vehicle vehicle) {
        for(FreightTransportData freightTransportData: freightTransportDatas){
            if(freightTransportData.getVehicle().equals(vehicle))
                return freightTransportData;
        }
        return null;
    }

    public void delete(FreightTransportData freightTransportData) {
        freightTransportDatas.remove(freightTransportData);
    }

    public void update(FreightTransportData freightTransportData) {
        //TODO
    }

    public List<FreightTransportData> getAllDriverTransports(Driver driver) {
        ArrayList<FreightTransportData> transports = new ArrayList<FreightTransportData>();
        for(FreightTransportData freightTransportData: freightTransportDatas){
            if(freightTransportData.getDriver().equals(driver))
                transports.add(freightTransportData);
        }
        return transports;
    }

    public List<FreightTransportData> getAllVehicleTransports(Vehicle vehicle) {
        ArrayList<FreightTransportData> transports = new ArrayList<FreightTransportData>();
        for(FreightTransportData freightTransportData: freightTransportDatas){
            if(freightTransportData.getVehicle().equals(vehicle))
                transports.add(freightTransportData);
        }
        return transports;
    }

    public List<FreightTransportData> getAllTrailerTransports(Trailer trailer) {
        ArrayList<FreightTransportData> transports = new ArrayList<FreightTransportData>();
        for(FreightTransportData freightTransportData: freightTransportDatas){
            if(freightTransportData.getTrailer().equals(trailer))
                transports.add(freightTransportData);
        }
        return transports;
    }
}
