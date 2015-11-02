package com.jdbc.demo.domain;


import java.sql.Date;

public class Vehicle {

    private int id;
    private int horsepower;
    private int engine;
    private int mileage;
    private String type;
    private String brand;
    private String VIN;
    private Date productionDate;
    private Date carReviewDate;
    private Date carReviewExpirationDate;
    private Boolean available;

    public Vehicle() {

    }

    public Vehicle(int id, String type, int engine,int mileage, Date production_date, String VIN, String brand, int horsepower,
                   Date carReviewDate, Date carReviewExpirationDate, Boolean available) {
        super();
        this.id = id;
        this.engine = engine;
        this.horsepower = horsepower;
        this.mileage = mileage;
        this.type = type;
        this.brand = brand;
        this.VIN = VIN;
        this.productionDate = production_date;
        this.carReviewDate = carReviewDate;
        this.carReviewExpirationDate = carReviewExpirationDate;
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (id != vehicle.id) return false;
        if (horsepower != vehicle.horsepower) return false;
        if (engine != vehicle.engine) return false;
        if (mileage != vehicle.mileage) return false;
        if (!type.equals(vehicle.type)) return false;
        if (!brand.equals(vehicle.brand)) return false;
        if (!VIN.equals(vehicle.VIN)) return false;
        //if (!productionDate.equals(vehicle.productionDate)) return false;
        if (carReviewDate != null ? !carReviewDate.equals(vehicle.carReviewDate) : vehicle.carReviewDate != null)
            return false;
        if (carReviewExpirationDate != null ? !carReviewExpirationDate.equals(vehicle.carReviewExpirationDate) : vehicle.carReviewExpirationDate != null)
            return false;
        return !(available != null ? !available.equals(vehicle.available) : vehicle.available != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + horsepower;
        result = 31 * result + engine;
        result = 31 * result + mileage;
        result = 31 * result + type.hashCode();
        result = 31 * result + brand.hashCode();
        result = 31 * result + VIN.hashCode();
        result = 31 * result + productionDate.hashCode();
        result = 31 * result + (carReviewDate != null ? carReviewDate.hashCode() : 0);
        result = 31 * result + (carReviewExpirationDate != null ? carReviewExpirationDate.hashCode() : 0);
        result = 31 * result + (available != null ? available.hashCode() : 0);
        return result;
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

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
