package com.jdbc.demo.domain;


import java.util.Date;

public class Vehicle {

    private static int idCounter=0;

    private int id;
    private int horsepower;
    private int engine;
    private String type;
    private String brand;
    private String VIN;
    private Date productionDate;
    private Date carReviewDate;
    private Date carReviewExpirationDate;
    private Boolean available;

    public Vehicle() {

    }

    public Vehicle(String type, int engine, Date production_date, String VIN, String brand, int horsepower,
                   Date carReviewDate, Date carReviewExpirationDate, Boolean available) {
        super();
        this.id = idCounter;
        this.engine = engine;
        this.horsepower = horsepower;
        this.type = type;
        this.brand = brand;
        this.VIN = VIN;
        this.productionDate = production_date;
        this.carReviewDate = carReviewDate;
        this.carReviewExpirationDate = carReviewExpirationDate;
        this.available = available;

        ++idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
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

    public Date getCarReviewExpirationDate() {
        return carReviewExpirationDate;
    }

    public void setCarReviewExpirationDate(Date carReviewExpirationDate) {
        this.carReviewExpirationDate = carReviewExpirationDate;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
