package com.yearup.dealership;

public class LeaseContract extends Contract {

    public LeaseContract(String date, String customerName,
                         String customerEmail, Vehicle vehicleSold) {

        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {

        double price = vehicleSold.getPrice();

        double endingValue = price * 0.50;

        double leaseFee = price * 0.07;

        return endingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {

        return getTotalPrice() * 0.04 / 36;
    }

}