package com.Model;

import java.sql.Timestamp;

public class CustomerLoginModel {
    private int customerId;
    private String firstName;
    private String lastName;
    private String customerEmail;
    private String password;
    private String customerPhoneNumber;
    private String customerAdress;
    private Timestamp registrationDate;

    // Constructor with fields
    public CustomerLoginModel(int customerId, String firstName, String lastName, String customerEmail, 
                               String password, String customerPhoneNumber, String customerAdress, Timestamp registrationDate) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerEmail = customerEmail;
        this.password = password;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerAdress = customerAdress;
        this.registrationDate = registrationDate;
    }

    // Default constructor
    public CustomerLoginModel() {
        // Default constructor body (if needed)
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }
}
