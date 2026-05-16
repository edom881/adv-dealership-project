package com.yearup.dealership;

public class Contract {
    protected String date;
    protected String customerName;
    protected String customerEmail;

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    protected Vehicle vehicleSold;


    }

