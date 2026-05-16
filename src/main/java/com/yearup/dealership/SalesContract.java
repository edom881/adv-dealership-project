package com.yearup.dealership;

public class SalesContract extends Contract {
    private boolean finance;

    public SalesContract(String date, String customerName,
                         String customerEmail, Vehicle vehicleSold,
                         boolean finance) {

        super(date, customerName, customerEmail, vehicleSold);
        this.finance = finance;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override
    public double getTotalPrice() {

        double price = vehicleSold.getPrice();

        double salesTax = price * 0.05;

        double recordingFee = 100;

        double processingFee;

        if (price < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }

        return price + salesTax + recordingFee + processingFee;
    }
    @Override
    public double getMonthlyPayment() {

        if (!finance) {
            return 0;
        }

        double totalPrice = getTotalPrice();
        double monthlyPayment;

        if (vehicleSold.getPrice() >= 10000) {
            monthlyPayment = totalPrice * 0.0425 / 12;
        } else {
            monthlyPayment = totalPrice * 0.0525 / 24;
        }

        return monthlyPayment;
    }
}

