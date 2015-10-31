package com.jdbc.demo.domain;

import java.math.BigDecimal;

/**
 * Created by Mateusz on 28-Oct-15.
 */
public class Cargo {

    private long id;
    private long type_id;
    private BigDecimal weight;
    private BigDecimal value;
    private int tax;
    private String name;
    private String security_type;

    public Cargo() {
    }

    public Cargo(long id, long type_id, BigDecimal weight, BigDecimal value, int tax, String name, String security_type) {
        this.id = id;
        this.type_id = type_id;
        this.weight = weight;
        this.value = value;
        this.tax = tax;
        this.name = name;
        this.security_type = security_type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecurity_type() {
        return security_type;
    }

    public void setSecurity_type(String security_type) {
        this.security_type = security_type;
    }
}
