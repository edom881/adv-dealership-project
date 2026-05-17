package com.yearup.dealership;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    private static final String FILE_NAME = "contracts.csv";

    public void saveContract(Contract contract) {

        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);

            if (contract instanceof SalesContract) {

                SalesContract salesContract = (SalesContract) contract;

                writer.write(
                        "SALE|" +
                                salesContract.getDate() + "|" +
                                salesContract.getCustomerName() + "|" +
                                salesContract.getCustomerEmail() + "|" +
                                salesContract.getVehicleSold().toString() + "|" +
                                salesContract.getTotalPrice() + "|" +
                                salesContract.getMonthlyPayment() + "\n"
                );
            }
            if (contract instanceof LeaseContract) {

                LeaseContract leaseContract = (LeaseContract) contract;

                writer.write(
                        "LEASE|" +
                                leaseContract.getDate() + "|" +
                                leaseContract.getCustomerName() + "|" +
                                leaseContract.getCustomerEmail() + "|" +
                                leaseContract.getVehicleSold().toString() + "|" +
                                leaseContract.getTotalPrice() + "|" +
                                leaseContract.getMonthlyPayment() + "\n"
                );
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving contract file.");
        }
    }


}
