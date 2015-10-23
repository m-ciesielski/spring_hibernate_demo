package com.jdbc.demo.domain;

import java.math.BigDecimal;

/**
 * Created by Mateusz on 22-Oct-15.
 */
public class Driver {


    private int id;
    private String firstName;
    private String lastName;
    private String PESEL;
    private BigDecimal salary;
    private BigDecimal salaryBonus;
    private Boolean available;
    private Boolean deleted;

    public Driver(){

    }

    public Driver(int id, String firstName, String lastName, String PESEL, BigDecimal salary,
                  BigDecimal salaryBonus, Boolean available, Boolean deleted) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.PESEL = PESEL;
        this.salary = salary;
        this.salaryBonus = salaryBonus;
        this.available = available;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getSalaryBonus() {
        return salaryBonus;
    }

    public void setSalaryBonus(BigDecimal salaryBonus) {
        this.salaryBonus = salaryBonus;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
