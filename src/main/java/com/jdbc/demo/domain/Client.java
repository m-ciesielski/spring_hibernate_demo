package com.jdbc.demo.domain;

/**
 * Created by Mateusz on 22-Oct-15.
 */
public class Client {

    private static int idCounter = 0;

    private int id;
    private int addressId;
    private String name;
    private String NIP;
    private String bankAccountIBAN;
    private String bankAccountNRB;
    private Boolean deleted;

    public Client() {

    }

    public Client(int addressId, String name, String NIP, String bankAccountIBAN,
                  String bankAccountNRB, Boolean deleted) {
        super();
        this.id = idCounter;
        this.addressId = addressId;
        this.name = name;
        this.NIP = NIP;
        this.bankAccountIBAN = bankAccountIBAN;
        this.bankAccountNRB = bankAccountNRB;
        this.deleted = deleted;

        ++idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getBankAccountIBAN() {
        return bankAccountIBAN;
    }

    public void setBankAccountIBAN(String bankAccountIBAN) {
        this.bankAccountIBAN = bankAccountIBAN;
    }

    public String getBankAccountNRB() {
        return bankAccountNRB;
    }

    public void setBankAccountNRB(String bankAccountNRB) {
        this.bankAccountNRB = bankAccountNRB;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
