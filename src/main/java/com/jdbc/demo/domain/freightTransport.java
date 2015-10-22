package com.jdbc.demo.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Mateusz on 22-Oct-15.
 */
public class FreightTransport {

    private static int idCounter = 0;

    private int id;
    private int clientId;
    private int loadAddressId;
    private int unloadAddressId;
    private int distance;
    private BigDecimal value;
    private Date loadDate;
    private Date unloadDate;
    private Date paymentDate;
    private Boolean finished;
    private String notes;

    public FreightTransport(){

    }

    public FreightTransport(int clientId, int loadAddressId, int unloadAddressId, int distance, BigDecimal value, Date loadDate, Date unloadDate, Date paymentDate, Boolean finished, String notes) {
        super();
        this.id = idCounter;
        this.clientId = clientId;
        this.loadAddressId = loadAddressId;
        this.unloadAddressId = unloadAddressId;
        this.distance = distance;
        this.value = value;
        this.loadDate = loadDate;
        this.unloadDate = unloadDate;
        this.paymentDate = paymentDate;
        this.finished = finished;
        this.notes = notes;

        ++idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getLoadAddressId() {
        return loadAddressId;
    }

    public void setLoadAddressId(int loadAddressId) {
        this.loadAddressId = loadAddressId;
    }

    public int getUnloadAddressId() {
        return unloadAddressId;
    }

    public void setUnloadAddressId(int unloadAddressId) {
        this.unloadAddressId = unloadAddressId;
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
