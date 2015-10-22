package com.jdbc.demo.domain;

import java.util.Date;

/**
 * Created by Mateusz on 22-Oct-15.
 */
public class Trailer {

    private static int idCounter = 0;

    private int id;
    private String brand;
    private String type;
    private double loadCapacity;
    private Date productionDate;
    private Date carReviewDate;
    private Date getCarReviewExpirationDate;
    private Boolean available;

    public Trailer(){

    }

    public Trailer(String brand, String type, double loadCapacity, Date productionDate,
                   Date carReviewDate, Date getCarReviewExpirationDate, Boolean available) {
        super();
        this.id = idCounter;
        this.brand = brand;
        this.type = type;
        this.loadCapacity = loadCapacity;
        this.productionDate = productionDate;
        this.carReviewDate = carReviewDate;
        this.getCarReviewExpirationDate = getCarReviewExpirationDate;
        this.available = available;

        ++idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getCarReviewDate() {
        return carReviewDate;
    }

    public void setCarReviewDate(Date carReviewDate) {
        this.carReviewDate = carReviewDate;
    }

    public Date getGetCarReviewExpirationDate() {
        return getCarReviewExpirationDate;
    }

    public void setGetCarReviewExpirationDate(Date getCarReviewExpirationDate) {
        this.getCarReviewExpirationDate = getCarReviewExpirationDate;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
