package com.jdbc.demo.domain;

import java.math.BigDecimal;

/**
 * Created by Mateusz on 23-Oct-15.
 */
public class FreightTransportData {

    private FreightTransport freightTransport;
    private Driver driver;
    private Vehicle vehicle;
    private Trailer trailer;
    private BigDecimal cost;
    private long distance;
    private long usedFuel;
    private String notes;

    public FreightTransportData(){

    }

    public FreightTransportData(FreightTransport freightTransport, Driver driver, Vehicle vehicle,
                                Trailer trailer, BigDecimal cost, long distance, long usedFuel, String notes) {
        this.freightTransport = freightTransport;
        this.driver = driver;
        this.vehicle = vehicle;
        this.trailer = trailer;
        this.cost = cost;
        this.distance = distance;
        this.usedFuel = usedFuel;
        this.notes = notes;
    }

    public FreightTransport getFreightTransport() {
        return freightTransport;
    }

    public void setFreightTransport(FreightTransport freightTransport) {
        this.freightTransport = freightTransport;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public long getUsedFuel() {
        return usedFuel;
    }

    public void setUsedFuel(long usedFuel) {
        this.usedFuel = usedFuel;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
