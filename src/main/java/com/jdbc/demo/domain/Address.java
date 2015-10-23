package com.jdbc.demo.domain;

/**
 * Created by Mateusz on 22-Oct-15.
 */
public class Address {


    private int id;
    private String town;
    private String street;
    private String code;
    private String houseNumber;

    public Address(){

    }

    public Address(int id, String town, String street, String code, String houseNumber) {
        super();
        this.id = id;
        this.town = town;
        this.street = street;
        this.code = code;
        this.houseNumber = houseNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
