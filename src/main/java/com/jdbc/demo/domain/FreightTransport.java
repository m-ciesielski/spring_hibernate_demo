package com.jdbc.demo.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Mateusz on 22-Oct-15.
 */
public class FreightTransport {

    private int id;
    private int loadAddressId;
    private int unloadAddressId;
    private int distance;
    private BigDecimal value;
    private Date loadDate;
    private Date unloadDate;
    private Date paymentDate;
    private Boolean finished;
    private String notes;
    private Client client;

    public FreightTransport(){

    }

    public FreightTransport(Client client, int loadAddressId, int unloadAddressId, int distance, BigDecimal value, Date loadDate, Date unloadDate, Date paymentDate, Boolean finished, String notes) {
        super();
        this.id = id;
        this.client = client;
        this.loadAddressId = loadAddressId;
        this.unloadAddressId = unloadAddressId;
        this.distance = distance;
        this.value = value;
        this.loadDate = loadDate;
        this.unloadDate = unloadDate;
        this.paymentDate = paymentDate;
        this.finished = finished;
        this.notes = notes;
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
