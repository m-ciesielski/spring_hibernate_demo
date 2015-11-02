package com.jdbc.demo.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by Mateusz on 22-Oct-15.
 */
public class FreightTransport {

    private int id;
    private Address loadAddress;
    private Address unloadAddress;
    private int distance;
    private BigDecimal value;
    private Date loadDate;
    private Date unloadDate;
    private Date paymentDate;
    private Boolean finished;
    private String notes;
    private Client client;
    private List<Vehicle> vehicles;
    private List<Driver> drivers;

    public FreightTransport(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getLoadAddress() {
        return loadAddress;
    }

    public void setLoadAddress(Address loadAddress) {
        this.loadAddress = loadAddress;
    }

    public Address getUnloadAddress() {
        return unloadAddress;
    }

    public void setUnloadAddress(Address unloadAddress) {
        this.unloadAddress = unloadAddress;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public Date getUnloadDate() {
        return unloadDate;
    }

    public void setUnloadDate(Date unloadDate) {
        this.unloadDate = unloadDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
