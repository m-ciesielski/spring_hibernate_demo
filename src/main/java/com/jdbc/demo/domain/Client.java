package com.jdbc.demo.domain;

/**
 * Created by Mateusz on 22-Oct-15.
 */
public class Client {

    private int id;
    private String name;
    private String NIP;
    private String bankAccountIBAN;
    private String bankAccountNRB;
    private Boolean deleted;
    private Address address;

    public Client() {

    }

    public Client(int id, Address address, String name, String NIP, String bankAccountIBAN,
                  String bankAccountNRB, Boolean deleted) {
        super();
        this.id = id;
        this.address = address;
        this.name = name;
        this.NIP = NIP;
        this.bankAccountIBAN = bankAccountIBAN;
        this.bankAccountNRB = bankAccountNRB;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
